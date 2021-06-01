package task4;

//In the class ArrayUtil write a public static generic method named "setAndReturn(...)" to modify and return the element in an array from the given position.
//
//Examples of usage:

public class ArrayUtil {
    // Write static method setAndReturn(...) here
    public static <T> T setAndReturn(T[] array, T value, int pos) {
        return array[pos] = value;
    }
}
