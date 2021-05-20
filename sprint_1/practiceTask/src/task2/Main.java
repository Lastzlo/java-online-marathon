package task2;

//task
//1. Create an instances of Employee class named 'emp1' and 'emp2'.
//2. Set not null values for 'fullName' and 'salary' properties.
//3. Create array of Employee type with name 'employees' and add two objects created before.
//4. Create variable with name 'employeesInfo' of String type.
//5. Using a loop, iterrate across array and write to variable named 'employeesInfo' info about each employee in next format:
// [{fullName: "<Full Name>", salary: "<Salary>"}, {fullName: "<Full Name>", salary: "<Salary>"}]

class Employee {
    public String fullName;
    public float salary;
}

public class Main {
    public static void main(String[] args) {
        // Create an instances of Employee class and use they here
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "name";
        emp1.salary = 100.0f;

        emp2.fullName = "name";
        emp2.salary = 100.0f;

        Employee employees[] = new Employee[]{emp1, emp2};

        String employeesInfo = "[";

        for(int i = 0; i < employees.length; i++) {
            employeesInfo += "{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}";

            if (i < (employees.length - 1)) {
                employeesInfo += ", ";
            }
        }

        employeesInfo += "]";
    }
}
