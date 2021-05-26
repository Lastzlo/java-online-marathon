package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    @Test
    void averageRating() {
        List<Caffee> caffees = new ArrayList<>(){{
            add(new Espresso ("Espresso", 8));
            add(new Cappuccino("Cappuccino", 10));
            add(new Espresso("Espresso", 10));
            add(new Cappuccino("Cappuccino", 6));
            add(new Caffee("Caffee", 6));
        }};

        Map<String, Double> averageRating = new MyUtils().averageRating(caffees);

        Set<String> namesOfCafees = averageRating.keySet();
        for (String nameOfCafee : namesOfCafees) {
            System.out.println(nameOfCafee + " = " + averageRating.get(nameOfCafee));
        }

        Assertions.assertEquals(3, averageRating.keySet().size());

        Assertions.assertTrue(averageRating.containsKey("Caffee"));
        Assertions.assertTrue(averageRating.containsKey("Espresso"));
        Assertions.assertTrue(averageRating.containsKey("Cappuccino"));

        Assertions.assertEquals(6.0, averageRating.get("Caffee"));
        Assertions.assertEquals(9.0, averageRating.get("Espresso"));
        Assertions.assertEquals(8.0, averageRating.get("Cappuccino"));

    }
}