package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilTest {


    @Test
    void convertTest() {
        char char1 = ' ';
        char char2 = 'e';

        to7BinaryString(char1);
        to7BinaryString(char2);

    }

    private static void to7BinaryString(char val) {
        String toBinaryString1 = Integer.toBinaryString(val);
        System.out.println("toBinaryString1 = " + toBinaryString1);

        String format = String.format("%7s", toBinaryString1);
        System.out.println("format = " + format);

        String replace = format.replace(' ', '0');
        System.out.println("replace = " + replace);
    }

    @Test
    void writeFile() {
        String filename = "src/main/java/task3/testData.txt";
        String text = "Hello!";
        String expected = "100100011001011101100110110011011110100001";

        MyUtil.writeFile(filename, text);

        try {
            String actual = Files.readString(Path.of(filename));
            Assertions.assertEquals(expected, actual);
        }catch (IOException e) {}

    }

    @Test
    void writeFile_sol2() {
        String filename = "src/main/java/task3/testData.txt";
        String text = "Hello!";
        String expected = "100100011001011101100110110011011110100001";

        MyUtil.writeFile_sol2(filename, text);

        try {
            String actual = Files.readString(Path.of(filename));
            Assertions.assertEquals(expected, actual);
        }catch (IOException e) {}

    }

    @Test
    void writeFile_sol2_1() {
        String filename = "src/main/java/task3/testData.txt";
        String text = "Hello!";
        String expected = "100100011001011101100110110011011110100001";

        MyUtil.writeFile_sol2_1(filename, text);

        try {
            String actual = Files.readString(Path.of(filename));
            Assertions.assertEquals(expected, actual);
        }catch (IOException e) {}

    }

}