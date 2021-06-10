package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    @Test
    void getCount_thenResult2() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int result = MyUtils.getCount(array, (i) -> (i < 3));

        Assertions.assertEquals(2, result);
    }

    @Test
    void getCount_wherePerdicateAlwaysReturnTrue_thenResult9() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int result = MyUtils.getCount(array, i -> true);

        Assertions.assertEquals(9, result);
    }
}