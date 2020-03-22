package io.ao9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {

	    try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++){
                            String currentTime = "The time is " + System.currentTimeMillis();
                            System.out.println("currentTime = " + currentTime);

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++){
                            int bytesLength = sourceChannel.read(buffer);
                            byte[] bytes = new byte[bytesLength];

                            buffer.flip();
                            buffer.get(bytes);
                            buffer.flip();

                            String currentTime = new String(bytes);
                            System.out.println("Read - CurrentTime = " + currentTime);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
