package task6;

//Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the Comparator<Type> generic interface.
//
//In the Utility class create public static method named sortPeople(...) that takes an array of Person type and derivative from it types, and comparator as input, and returns the value of void type.
//
//Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.
//
//The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)
//
//As implementation of sortPeople(...) method use the next code:

public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level;
    }
}

enum Level {
    JUNIOR, MIDDLE, SENIOR
}