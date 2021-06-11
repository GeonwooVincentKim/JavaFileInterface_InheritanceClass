package InheritedClass.Files;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Files {
    private File file;
    private Scanner fileReader;
    private FileWriter fileWriter;

    public Files(File file, Scanner fileReader, FileWriter fileWriter) {
        this.setFile(file);
        this.setFileReader(fileReader);
        this.setFileWriter(fileWriter);
    }

    public Scanner getFileReader() {
        return fileReader;
    }

    public void setFileReader(Scanner fileReader) {
        this.fileReader = fileReader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
