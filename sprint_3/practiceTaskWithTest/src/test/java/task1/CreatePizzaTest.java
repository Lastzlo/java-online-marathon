package task1;

import org.junit.jupiter.api.Test;

public class CreatePizzaTest {
    @Test
    void createTwoNotSamePizzas() {
        Pizza pizza1 = Pizza
                .base()

                .addCheese("Ratfor")
                .addMeat("Beacon")
                .addVegetable("Pineapple")

                .build();
        System.out.println("pizza1.toString() = " + pizza1.toString());

        Pizza pizza2 = Pizza
                .base()

                .addVegetable("Pineapple")

                .build();
        System.out.println("pizza2.toString() = " + pizza2.toString());

        Pizza pizza3 = Pizza
                .base()

                .build();
        System.out.println("pizza3.toString() = " + pizza3.toString());
    }
}
