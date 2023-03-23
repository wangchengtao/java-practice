package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFIle {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/app");
        System.out.println(file.getPath());

        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.toString().endsWith("java")) {
                    System.out.println(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
