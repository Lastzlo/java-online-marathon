package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    //TestCase1 {1, 2, 3, -1, -5, 0}
    @Test
    void getChanged_whenTestCase1() {
        double[] array = {1, 2, 3, -1, -5, 0};

        double[] changed = App.getChanged(array, App.cons);

        System.out.println(Arrays.toString(changed));
    }
}