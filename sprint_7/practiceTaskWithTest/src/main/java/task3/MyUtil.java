package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**Create the method writeFile(String filename, String text) that write the text to file as sequence of bytes in binary format.

 For example, the text fragment
 Hello!

 should be represented in the file as a sequence of 7-bit bytes without spaces between them:
 100100011001011101100110110011011110100001

 100100011001011101100110110011011110100001

 If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.*/

public class MyUtil {
    public static void writeFile(String filename, String text) {

        String textTo7bit = text.chars()
                .mapToObj(Integer::toBinaryString)
                .map(i -> String.format("%7s", i))
                .map(i -> i.replace(' ', '0'))
                .reduce((s1, s2) -> s1 + s2)
                .get();

        try {
            Files.writeString(Path.of(filename), textTo7bit);
        }catch (IOException e) {}

    }

    public static void writeFile_sol2(String filename, String text) {

        String textTo7bit = text.chars()
                .mapToObj(Integer::toBinaryString)  //integer char value to toBinaryString
                .map(i -> String.format("%7s", i))  //change format to 7 bit
                .collect(Collectors.joining())  //equals concat all values
                .replaceAll(" ", "0");

        try {
            Files.writeString(Path.of(filename), textTo7bit);
        }catch (IOException e) {}

    }


    public static void writeFile_sol2_1(String filename, String text) {

        String textTo7bit = text.chars()
                .mapToObj(Integer::toBinaryString)  //integer char value to toBinaryString
                .map(i -> String.format("%7s", i))  //change format to 7 bit
                .collect(Collectors.joining())  //equals concat all values
                .replaceAll(" ", "0");

        try {
            Files.writeString(
                    Path.of(filename),
                    text.chars()
                            .mapToObj(Integer::toBinaryString)  //integer char value to toBinaryString
                            .map(i -> String.format("%7s", i))  //change format to 7 bit
                            .collect(Collectors.joining())  //equals concat all values
                            .replaceAll(" ", "0"));
        }catch (IOException e) {}

    }

}
