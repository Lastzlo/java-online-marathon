package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountantTest {

    @Test
    void sum() {
        int sum = Accountant.sum(100, 5);
        assertEquals(105, sum);

        sum = Accountant.sum(100, 500);
        assertEquals(600, sum);
    }
}