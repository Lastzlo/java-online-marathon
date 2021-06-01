package task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonComparatorTest {

    @Test
    void compare() {
        Person person1 = new Person("Ivan", 37);
        Person person2 = new Person("Ivan", 37);
        Person person3 = new Person("Oleh", 28);
        Person person4 = new Person("Ivan", 25);
        Person person5 = new Person("Oleh", 37);

        assertEquals(0, new PersonComparator().compare(person1, person2), "should be 0");
        assertTrue( new PersonComparator().compare(person1, person3) < 0, "should be < 0");
        assertTrue( new PersonComparator().compare(person1, person4) > 0, "should be > 0");
        assertTrue( new PersonComparator().compare(person1, person5) < 0, "should be < 0");


    }
}