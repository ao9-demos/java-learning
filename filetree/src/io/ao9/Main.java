package io.ao9;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath("filetree/dir2");

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isRegularFile(entry);
            }
        };

        try(DirectoryStream<Path> directoryStream =
//                    Files.newDirectoryStream(directory, "*.dat")){
                    Files.newDirectoryStream(directory, filter)){
                for(Path file : directoryStream){
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        String separator = File.separator;
        System.out.println("separator = " + separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println("separator = " + separator);


        try {
            Path tempFile = Files.createTempFile("myapp",".abc");
            System.out.println(tempFile.toAbsolutePath());

        } catch (IOException e){
            e.printStackTrace();
        }


        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores){
            System.out.println("store = " + store);
            System.out.println("store.name() = " + store.name());
        }

        Iterable<Path> paths = FileSystems.getDefault().getRootDirectories();
        for(Path path : paths){
            System.out.println("path = " + path);
        }

        try {
            Files.walkFileTree(directory,new PrintNames());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path copyPath = FileSystems.getDefault().getPath("filetree","dir4","dir2copy");
        try {
            Files.walkFileTree(directory,new CopyFiles(directory,copyPath));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
