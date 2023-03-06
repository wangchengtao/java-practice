package Item1;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileFilterVisitor extends SimpleFileVisitor<Path> {
    private String extension;
    private List<String> filteredFileNames  = new ArrayList<>();

    public MyFileFilterVisitor(String extension) {
        this.extension = extension;
    }

    public List<String> getFilteredFileNames() {
        return filteredFileNames;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("Visit " + file);

        if (file.toString().endsWith(extension)) {
            this.filteredFileNames.add(file.getFileName().toString());
        }

        return FileVisitResult.CONTINUE;
    }
}
