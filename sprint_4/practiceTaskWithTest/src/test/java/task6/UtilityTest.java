package task6;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void sortPeople_whenComparePeoples() {
        Person person1 = new Person("Ivan", 37);
        Person person2 = new Person("Ivan", 37);
        Person person3 = new Person("Oleh", 28);
        Person person4 = new Person("Ivan", 25);
        Person person5 = new Person("Oleh", 37);

        Person[] people = {person1, person2, person3, person4, person5};

        System.out.println("when");
        for (Person p : people) {
            System.out.println("p.toString() = " + p.toString());
        }


        Utility.<Person>sortPeople(people, new PersonComparator());

        System.out.println("then");
        for (Person p : people) {
            System.out.println("p.toString() = " + p.toString());
        }
    }

    @Test
    void sortPeople_whenCompareDevelopers() {
        Developer person1 = new Developer("Ivan", 37, 3000.0, Level.JUNIOR);
        Developer person2 = new Developer("Ivan", 37, 3000.0, Level.MIDDLE);
        Developer person3 = new Developer("Oleh", 28, 3000.0, Level.MIDDLE);
        Developer person4 = new Developer("Ivan", 25, 3000.0, Level.SENIOR);
        Developer person5 = new Developer("Oleh", 37, 3000.0, Level.SENIOR);

        Developer[] developers = {person1, person2, person3, person4, person5};

        System.out.println("when");
        for (Developer p : developers) {
            System.out.println("p.toString() = " + p.toString());
        }


        Utility.<Developer>sortPeople(developers, new DeveloperComparator());

        System.out.println("then");
        for (Developer p : developers) {
            System.out.println("p.toString() = " + p.toString());
        }
    }


    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) { return 0; }
    }

//    @Test
//    void sortPeople_whenCompareStrings() {
//        String[] strings = {"ca", "ab", "dc", "bd"};
//
//        System.out.println("when");
//        for (String s : strings) {
//            System.out.println("s = " + s);
//        }
//
//        Utility.sortPeople(strings, new StringComparator());
//
//        System.out.println("then");
//        for (String s : strings) {
//            System.out.println("s = " + s);
//        }
//
//    }
}