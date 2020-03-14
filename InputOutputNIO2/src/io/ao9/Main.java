package io.ao9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel();
             RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
             FileChannel channel = ra.getChannel()) {

            //write to buffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(100);
            byte[] outputBytes1 = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you!".getBytes();
            writeBuffer.put(outputBytes1).putInt(666).putInt(888).put(outputBytes2).putInt(999);
//            writeBuffer.putInt(666);
//            writeBuffer.putInt(888);
//            writeBuffer.put(outputBytes2);
//            writeBuffer.putInt(999);
            //use channel to read from buffer, and write to file
            writeBuffer.flip();
            binChannel.write(writeBuffer);

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            //use channel to read from file, and write to buffer
            channel.read(readBuffer);
            readBuffer.flip();
            //read from buffer
            byte[] inputBytes1 = new byte[outputBytes1.length];
            readBuffer.get(inputBytes1);
            System.out.println("new String(inputBytes1) = " + new String(inputBytes1));
            System.out.println("readBuffer.getInt() = " + readBuffer.getInt());
            System.out.println("readBuffer.getInt() = " + readBuffer.getInt());
            byte[] inputBytes2 = new byte[outputBytes2.length];
            readBuffer.get(inputBytes2);
            System.out.println("new String(inputBytes2) = " + new String(inputBytes2));
            System.out.println("readBuffer.getInt() = " + readBuffer.getInt());


//            byte[] outputBytes = "Hello World!".getBytes();
//            //warp automatically flip buffer to 0
////            ByteBuffer byteBuffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer byteBuffer = ByteBuffer.allocate(outputBytes.length);
//            byteBuffer.put(outputBytes);
//            byteBuffer.flip();
//            int numBytes = binChannel.write(byteBuffer);
//            System.out.println("numBytes = " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            //putInt doesn't automatically flip buffer to 0
//            intBuffer.putInt(666);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes = " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(888);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes = " + numBytes);
//
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            byteBuffer.flip();
//            long numBytesRead = channel.read(byteBuffer);
//            System.out.println("numBytesRead = " + numBytesRead);
//            System.out.println("new String(outputBytes) = " + new String(outputBytes));
//            if (byteBuffer.hasArray()) {
//                System.out.println("new String(byteBuffer.array()) = " + new String(byteBuffer.array()));
//            }
//
////            Absolute read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println("numBytesRead = " + numBytesRead);
//            System.out.println("intBuffer.getInt(0) = " + intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println("numBytesRead = " + numBytesRead);
//            System.out.println("intBuffer.getInt(0) = " + intBuffer.getInt(0));
//
//
////            Relative read
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println("intBuffer.getInt() = " + intBuffer.getInt());
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println("intBuffer.getInt() = " + intBuffer.getInt());
//
//
////            byte[] bytes = new byte[outputBytes.length];
////            ra.read(bytes);
////            System.out.println(new String(bytes));
////
////            int int1 = ra.readInt();
////            int int2 = ra.readInt();
////            System.out.println(int1 + " " + int2);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        Path filePath = FileSystems.getDefault().getPath("data.txt");
//        try {
//            List<String> lines = Files.readAllLines(filePath);
//            for (String line : lines) {
//                System.out.println(line);
//            }
//            String lastLine = lines.get(lines.size() - 1);
//            String[] lastLineArr = lastLine.split(" ");
//            int lastLineNum = Integer.valueOf(lastLineArr[lastLineArr.length - 1]);
//            Files.write(filePath, ("\nLine " + (lastLineNum + 1)).getBytes("UTF-8"), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
