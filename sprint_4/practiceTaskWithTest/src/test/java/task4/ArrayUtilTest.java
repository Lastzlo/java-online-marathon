package task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

    @Test
    void setAndReturn_whenTypeInteger() {
        Integer[] numbers = new Integer[10];
        int numberForSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);

        assertEquals(52, numberForSecondPosition);
        assertEquals(52,numbers[1], "it should be 52");
    }

    @Test
    void setAndReturn_whenTypeString() {
        String[] words = new String[10];
        String wordForSecondPosition = ArrayUtil.<String>setAndReturn(words, "hello", 1);

        assertEquals("hello", wordForSecondPosition);
        assertEquals("hello",words[1], "it should be 'hello'");
    }

    @Test
    void setAndReturn_whenTypeString_bytPutNull() {
        String[] words = new String[10];
        String wordForSecondPosition = ArrayUtil.<String>setAndReturn(words, null, 1);

        assertNull(wordForSecondPosition);
        assertNull(words[1], "it should be null");
    }

    @Test
    void setAndReturn_whenWithoutType_bytPutString() {
        String[] words = new String[10];
        String wordForSecondPosition = ArrayUtil.setAndReturn(words, "hello", 1);

        assertEquals("hello", wordForSecondPosition);
        assertEquals("hello",words[1], "it should be 'hello'");
    }
}