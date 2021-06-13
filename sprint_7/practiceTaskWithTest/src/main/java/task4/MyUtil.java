package task4;

import java.io.FileReader;
import java.io.IOException;


/*Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task Very hardly task */


/**Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.

 For example, the sequence of 7-bit bytes*/
public class MyUtil {

    public static String readFile(String filename) {
        StringBuilder byteText = new StringBuilder();

        try (FileReader fileReader = new FileReader(filename)){
            int c;
            while ((c = fileReader.read()) != -1 ) {
                byteText.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < byteText.length(); i += 7) {
            String oneLetter = byteText.substring(i, i + 7);
            resultText.append((char) Integer.parseInt(oneLetter, 2));
        }

        return resultText.toString();
    }
}
