package task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void addAtoB() {
        assertEquals(9.0 , Operations.addAtoB(6, 3));
    }

    @Test
    void subtractBfromA() {
        assertEquals(3.0 , Operations.subtractBfromA(6, 3));
    }

    @Test
    void multiplyAbyB() {
        assertEquals(18.0 , Operations.multiplyAbyB(6, 3));
    }

    @Test
    void divideAbyB() {
        assertEquals(2.0 , Operations.divideAbyB(6, 3));
    }
}