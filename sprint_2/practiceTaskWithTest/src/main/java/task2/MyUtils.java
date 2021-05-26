package task2;

import java.util.*;

// Task 2
// Create interface DrinkReceipt with methods String getName() and DrinkReceipt addComponent(String componentName, int componentCount). Create interface DrinkPreparation with method Map<String, Integer> makeDrink() to return a drink components. Create interface Rating with method int getRating().
//Class Caffee contains fields String name, int rating, Map of ingredients and implements interfaces DrinkReceipt, DrinkPreparation and Rating. Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}. Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink(). Espresso caffee has 50 g. of Water. Cappuccino caffee has an additional of 50 g. of Milk.
//Create a averageRating() method of the MyUtils class to return a Map with coffee name as key and coffee average rating as value.
//For example, for a given list
//[Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10], Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6], Caffee [name=Caffee, rating=6]]
//you should get
//{Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
//
//Answer:(penalty regime: 0 %)

interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);

}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;


    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    };

    @Override
    public String getName(){
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount){
        return null;
    }

    @Override
    public Map<String, Integer> makeDrink(){
        return new HashMap<>(){{
            put("Water", 100);
            put("Arabica", 20);
        }};
    }

    @Override
    public int getRating(){
        return rating;
    }
}

class Espresso extends Caffee {
    public Espresso(String name, int rating) {
        super(name, rating);
    };

    @Override
    public Map<String, Integer> makeDrink(){
        return new HashMap<>(){{
            put("Water", 50);
            put("Arabica", 20);
        }};
    }

}

class Cappuccino extends Caffee {

    public Cappuccino(String name, int rating) {
        super(name, rating);
    };

    @Override
    public Map<String, Integer> makeDrink(){
        return new HashMap<>(){{
            put("Water", 100);
            put("Arabica", 20);
            put("Milk", 50);
        }};
    }
}

public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        // store coffees with their ratings
        Map<String, List<Integer>> coffeesWithRatings = new HashMap<>();

        coffees.forEach(coffee -> {
            String coffeeName = coffee.getName();

            if(coffeesWithRatings.containsKey(coffeeName)) {
                List<Integer> listOfRatings = coffeesWithRatings.get(coffeeName);
                listOfRatings.add(coffee.getRating());
            } else {
                List<Integer> listOfRatings = new ArrayList<>(){{add(coffee.getRating());}};
                coffeesWithRatings.put(coffeeName, listOfRatings);
            }
        });

        // store results
        Map<String, Double> resultMap = new HashMap<>();

        final Set<String> coffeesNamesSet = coffeesWithRatings.keySet();
        for (String coffeeName : coffeesNamesSet) {
            Integer[] ratings =
                    coffeesWithRatings
                            .get(coffeeName)            //get list of ratings
                            .toArray(new Integer[]{});  //convert to array

            double sumOfRatings = 0.0;
            for (int rating : ratings) {
                sumOfRatings += rating;
            }

            //put to resultMap coffee name and average rating
            resultMap.put(coffeeName, (sumOfRatings / ratings.length));
        }

        return resultMap;
    }
}

