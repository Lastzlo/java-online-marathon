package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

    @Test
    void averageValue() {
        Array<Integer> integerArray = new Array<>(new Integer[] {1, 2, 4, 5});
        double averageValue = ArrayUtil.averageValue(integerArray);
        assertEquals(3.0, averageValue);

    }

    @Test
    void averageValue_whenPutDouble() {
        Array<Double> doubleArray = new Array<>(new Double[] {1.0, 2.0, 4.0, 5.0});
        double averageValue = ArrayUtil.averageValue(doubleArray);
        assertEquals(3.0, averageValue);

    }

    @Test
    void averageValue_whenPutNull() {
        Array<Double> doubleArray = new Array<>(new Double[] {3.0, null, 4.0, 5.0});
        double averageValue = ArrayUtil.averageValue(doubleArray);
        assertEquals(3.0, averageValue);

    }
}