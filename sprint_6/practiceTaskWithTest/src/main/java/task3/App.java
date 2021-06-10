package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**Add to App class static field greetingOperator of type BinaryOperator.

 The greetingOperator should create a new string as a result by the rule: "Hello " + parameter1 + " " + parameter2 + "!!!"

 Create a static method createGreetings(...) that takes two parameters: List<Person> and BinaryOperator and generates List<String> as a result. We should be able to pass greetingOperator as a parameter here.

 Please, use the second parameter in creating the result.*/

public class App {

    static BinaryOperator<String> greetingOperator = (parameter1, parameter2) -> ("Hello " + parameter1 + " " + parameter2 + "!!!");

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {
        List<String> resultList = new ArrayList<>();
        for(Person person : people) {
            resultList.add(greetingOperator.apply(person.name, person.surname));
        }

        return resultList;
    }
}
