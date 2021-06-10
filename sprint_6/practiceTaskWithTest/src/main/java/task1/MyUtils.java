package task1;

import java.util.Arrays;
import java.util.function.Predicate;

/**Implement a static method getCount(...)
 *  that takes an array of integers as the first parameter.
 *  The second parameter is a functional interface that works with integers
 *  and defines a some condition.

 The method should return the count of elements in the array
 that satisfy the condition defined by the second argument.*/

public class MyUtils {
//    public static int getCount(int[] array,Condition condition ) {
//        int count = 0;
//        for (int i : array) {
//            if(condition.method(i)) count++;
//        }
//        return count;
//    }

    public static int getCount(int[] array,Predicate<Integer> predicate ) {
        int count = 0;
        for (int i : array) {
            if (predicate.test(i)) count ++;
        }
        return count;
    }
}

//@FunctionalInterface
//interface Condition {
//    boolean method(int value);
//}
