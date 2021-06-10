package task5;

import java.util.function.Predicate;
import java.util.Set;

public class MyUtils {
//    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
//        Predicate<Integer> predicate1 = (Integer i) -> (i > 3);
//        Predicate<Integer> predicate2 = (Integer i) -> (i < 10);
//
//
//
//        //реализация в один шаг;
//        //Predicate<Integer> count = i -> predicate1.test(i) && predicate2.test(i) ;
//
//        Predicate<Integer> count = i -> {
//            for (Predicate<Integer> predicate : predicates) {
//                if (! predicate.test(i)) return false;
//            }
//            return true;
//        };
//
//
//        return count;
//    };

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        return i -> {
            for (Predicate<Integer> predicate : predicates) {
                if (! predicate.test(i)) return false;
            }
            return true;
        };
    }
}
