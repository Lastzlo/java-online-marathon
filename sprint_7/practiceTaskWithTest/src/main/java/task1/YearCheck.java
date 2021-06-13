package task1;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

public class YearCheck {

public static boolean isLeapYear(int year) {
    try {
        LocalDate.of(year, 2, 29);
        return true;
    } catch (DateTimeException e) {
        return false;
    }
}
    
    @Test
    void run_1() {
        boolean leapYear = isLeapYear(1974);
        System.out.println("leapYear = " + leapYear);
    }

}
