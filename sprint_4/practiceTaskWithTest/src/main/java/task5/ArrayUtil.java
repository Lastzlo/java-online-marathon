package task5;
//In the class ArrayUtil write static method named "averageValue(...)" that takes an object of Array type as input, and returns the average value its elements.
//
//The given method should returns value of double type and take any array, whose elements extends Number type.
public class ArrayUtil {

    public static <T extends Number> double averageValue(Array<T> array) {
        double sum = 0.0;
        for (int i = 0; i < array.length(); i++) {
            if (array.get(i) != null) sum += array.get(i).doubleValue();
        }

        return sum / array.length();
    }
}
