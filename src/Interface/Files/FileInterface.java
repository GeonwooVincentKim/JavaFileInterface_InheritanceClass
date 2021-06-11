package Interface.Files;

import java.util.Scanner;

public interface FileInterface {
    public Scanner fileReader(String fileName);

    public void fileWriter(String fileName, String result);
}
