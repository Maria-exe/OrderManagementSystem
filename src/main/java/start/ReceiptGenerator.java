package start;
import java.io.*;

/**
 * Class that implements a Singleton design pattern for writing in a file the billing information for a order that has been placed
 *
 * @author Tirlea Maria Cristina
 * @since Apr 20, 2021
 */
public class ReceiptGenerator {
    private static ReceiptGenerator single_instance =new ReceiptGenerator();
    private PrintWriter writer;
    private File file;
    private ReceiptGenerator()  {
        file = new File("bill.txt");
        try {
            writer = new PrintWriter(file, "UTF-8");
            BufferedWriter buffer = new BufferedWriter(writer);
        } catch (IOException e) {
            System.out.println("Error: opening receipt file.");
        }
    }

    /**
     * Method for accessing the single instance of this class
     *
     * @return single instance of ReceiptGenerator class
     */
    public static ReceiptGenerator getInstance() {
        return single_instance;
    }

    public File getFile() {
        return file;
    }

    /**
     * Method for writing in file
     *
     * @param obj object to be written in the file
     */
    public void writeInFile(Object obj) {
        synchronized (single_instance) {
            writer.print(obj);
        }
    }

    public PrintWriter getWriter() {
        return writer;
    }

}