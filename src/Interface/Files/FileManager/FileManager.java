package Interface.Files.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Interface.Files.FileInterface;

public class FileManager implements FileInterface {

    @Override
    public Scanner fileReader(String fileName) {
        Scanner fileReader = null;
        File file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    @Override
    public void fileWriter(String fileName, String result) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
