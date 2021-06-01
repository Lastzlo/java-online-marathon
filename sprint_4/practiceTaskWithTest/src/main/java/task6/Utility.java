package task6;

import java.util.Arrays;
import java.util.Comparator;

public class Utility {

    public static <T extends Person> void sortPeople(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        final int compareNames = o1.getName().compareTo(o2.getName());
        return (compareNames == 0) ? Integer.compare(o1.getAge(), o2.getAge()) : compareNames;
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        final int comparePersons = new PersonComparator().compare(o1, o2);
        return (comparePersons == 0) ? Double.compare(o1.getSalary(), o2.getSalary()) : comparePersons;
    }
}

class DeveloperComparator implements Comparator<Developer>{

    @Override
    public int compare(Developer o1, Developer o2) {
        final int compareEmployees = new EmployeeComparator().compare(o1, o2);
        return (compareEmployees == 0) ? o1.getLevel().compareTo(o2.getLevel()) : compareEmployees;
    }
}
