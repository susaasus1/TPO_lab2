package csv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Printer {
    public void csvPrint(double number, double answer, String path) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(path, true));
        printStream.printf("%s, %s \n", number, answer);
    }
}
