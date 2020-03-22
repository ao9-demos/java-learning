package io.ao9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {
            Path sourcePath = FileSystems.getDefault().getPath("files","file1.txt");
            Path copyPath = FileSystems.getDefault().getPath("files", "copyFile1.txt");
            Files.copy(sourcePath,copyPath, StandardCopyOption.REPLACE_EXISTING);
            printFile(copyPath);

            sourcePath = FileSystems.getDefault().getPath("files", "dir1");
            copyPath = FileSystems.getDefault().getPath("files", "dir4");
            Files.copy(sourcePath,copyPath, StandardCopyOption.REPLACE_EXISTING);

            sourcePath = FileSystems.getDefault().getPath("files", "copyFile1.txt");
            Path movePath = FileSystems.getDefault().getPath("files", "dir1", "copyFile1.txt");
            Files.move(sourcePath,movePath, StandardCopyOption.REPLACE_EXISTING);


            Path deletePath = FileSystems.getDefault().getPath("files", "dir1", "copyFile1.txt");
            System.out.println("Deleting file " + deletePath.toAbsolutePath());

//            Files.delete(deletePath);
            Files.deleteIfExists(deletePath);
            System.out.println("\nDeleted.");


            Path createPath = FileSystems.getDefault().getPath("files", "createFile1.txt");
            if (!Files.exists(createPath)) {
                Files.createFile(createPath);
            }

            Path createDirPath = FileSystems.getDefault().getPath("files", "dir5/dir6","dir7\\dir8");
            Files.createDirectories(createDirPath);

            Path filePath = FileSystems.getDefault().getPath("files","file1.txt");
            System.out.println("Files.size(filePath) = " + Files.size(filePath));
            System.out.println("Files.getLastModifiedTime(filePath) = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("attrs.size() = " + attrs.size());
            System.out.println("attrs.creationTime() = " + attrs.creationTime());
            System.out.println("attrs.lastModifiedTime() = " + attrs.lastModifiedTime());
            System.out.println("attrs.isRegularFile() = " + attrs.isRegularFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Path workingPath = FileSystems.getDefault().getPath("WorkingDirectory.txt");
//        printFile(workingPath);
//        Path subPath1 = FileSystems.getDefault().getPath("files", "SubDirectory.txt");
//        printFile(subPath1);
//        Path subPath2 = Paths.get(".", "files", "SubDirectory.txt");
//        printFile(subPath2);
//        Path upperPath = Paths.get("D:\\Sync\\Projs\\java-learning\\UpperDirectory.txt");
////        Path upperPath = Paths.get("D:", "\\Sync\\Projs\\java-learning\\UpperDirectory.txt");
////        Path upperPath = Paths.get("D:", "Sync\\Projs\\java-learning\\UpperDirectory.txt");
////        Path upperPath = Paths.get("D:", "Sync\\Projs", "java-learning\\UpperDirectory.txt");
////        Path upperPath = Paths.get(".", "..", "UpperDirectory.txt");
//        printFile(upperPath);
//
//        Path projectPath = Paths.get(".");
//        System.out.println(projectPath.toAbsolutePath());
//        System.out.println(projectPath.normalize().toAbsolutePath());
////        D:\\example\.\subfolder == D:\\example\\subfolder
////        D:\\example\.\subfolder\..\directory == D:\\example\\directory
//
//
//        Path path1 = FileSystems.getDefault().getPath("notExist.txt");
//        System.out.println(Files.exists(path1));
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            System.out.println(path.toAbsolutePath());

            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
