package task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumTaskTest {

    @Test
    void drawLine_whenLineTypeDOTTED() {
        assertEquals("The line is dotted type",
                EnumTask.drawLine(EnumTask.LineType.DOTTED));
    }
}