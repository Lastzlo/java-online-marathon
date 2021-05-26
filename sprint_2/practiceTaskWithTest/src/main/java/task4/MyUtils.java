package task4;

import java.math.BigDecimal;
import java.util.*;

//task4
//Create classes Employee (fields String name, int experience and BigDecimal basePayment) and Manager (field double coefficient) with methods which return the general working experience and payment for work done.
//A getter methods of class Employee return value of all fields: getName(), getExperience() and getPayment().
//Classes Manager is derived from class Employee and override getPayment() method to return multiplication of a coefficient and base payment.
//Create a largestEmployees() method of the MyUtils class to return a List of unique employees with maximal working experience and payment without duplicate objects.
//The original list must be unchanged.
//For example, for a given list
// [Employee [name=Ivan, experience=10, basePayment=3000.00], Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],  Employee [name=Stepan, experience=8, basePayment=4000.00], Employee [name=Andriy, experience=7, basePayment=3500.00], Employee [name=Ihor, experience=5, basePayment=4500.00], Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
//you should get
//[Employee [name=Ivan, experience=10, basePayment=3000.00], Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], Employee [name=Ihor, experience=5, basePayment=4500.00]].

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return experience == employee.experience
                && Objects.equals(name, employee.name)
                && Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", experience=" + getExperience() +
                ", basePayment=" + getPayment() +
                ", coefficient=" + coefficient +
                '}';
    }
}

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        Set<Employee> resultSet = new HashSet<>();

        Comparator<Employee> byExperience =
                (Employee empl1, Employee empl2) -> Integer.compare(empl1.getExperience(), empl2.getExperience());
        Collections.sort(workers, byExperience);

        if(!workers.isEmpty()) {
            Employee bestEmpl = workers.get(workers.size() - 1);
            resultSet.add(bestEmpl);

            for(Employee employee : workers){
                if (employee.getExperience() == bestEmpl.getExperience()) {
                    resultSet.add(employee);
                }
            }
        }

        Comparator<Employee> byPayment =
                (Employee empl1, Employee empl2) -> empl1.getPayment().compareTo(empl2.getPayment());
        Collections.sort(workers, byPayment);

        if(!workers.isEmpty()) {
            Employee bestEmpl = workers.get(workers.size() - 1);
            resultSet.add(bestEmpl);

            for(Employee employee : workers){
                if (employee.getPayment().compareTo(bestEmpl.getPayment()) == 0) {
                    resultSet.add(employee);
                }
            }
        }

        List<Employee> result = new ArrayList<>(resultSet);

        return result;
    }
}
