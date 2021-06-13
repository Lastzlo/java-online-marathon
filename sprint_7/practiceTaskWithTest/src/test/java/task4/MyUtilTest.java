package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task4.MyUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilTest {

    @Test
    void readFile() {
        String filename = "src/main/java/task3/testData.txt";
        String expected = "Hello!";

        String actual = MyUtil.readFile(filename);
        Assertions.assertEquals(expected, actual);

    }
}