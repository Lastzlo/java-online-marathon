package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTypeTest {

    @Test
    void getDiscount_whereClientStatusSILVER() {
        assertEquals(0.97, ClientType.SILVER.discount());
    }

    @Test
    void getDiscount_whereClientStatusNew() {
        assertEquals(1.0, ClientType.NEW.discount());
    }
}