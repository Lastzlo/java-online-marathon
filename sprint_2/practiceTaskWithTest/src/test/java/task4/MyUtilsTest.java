package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class MyUtilsTest {

    //For example, for a given list
    // [
    //  Employee [name=Ivan, experience=10, basePayment=3000.00],
    //  Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
    //  Employee [name=Stepan, experience=8, basePayment=4000.00],
    //  Employee [name=Andriy, experience=7, basePayment=3500.00],
    //  Employee [name=Ihor, experience=5, basePayment=4500.00],
    //  Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]
    // ]

    //you should get
    //  [
    //      Employee [name=Ivan, experience=10, basePayment=3000.00],
    //      Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
    //      Employee [name=Ihor, experience=5, basePayment=4500.00]
    //  ]
    @Test
    void largestEmployees_whenUseExampleData() {
        //when
        List<Employee> workers = new ArrayList<>(){{
            add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
            add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
            add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
            add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
            add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
            add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));

        }};

        //then
        List<Employee> employeeList = new MyUtils().largestEmployees(workers);

        for (Employee empl : employeeList) {
            System.out.println("empl = " + empl);
        }

        Assertions.assertEquals(3, employeeList.size());
    }

    @Test
    void largestEmployees_whenDuplicateEmployees() {
        //when
        List<Employee> workers = new ArrayList<>(){{
            add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
            add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
            add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
            add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
            add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
            add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));
            add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
            add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));

        }};

        //then
        List<Employee> employeeList = new MyUtils().largestEmployees(workers);

        for (Employee empl : employeeList) {
            System.out.println("empl = " + empl);
        }

        Assertions.assertEquals(3, employeeList.size());
    }
}