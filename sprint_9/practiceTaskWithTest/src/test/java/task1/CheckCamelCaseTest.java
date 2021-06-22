package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckCamelCaseTest {

    @Test
    void checkAndPrint_whereClass1() {
        CheckCamelCase.checkAndPrint(Class1.class);
    }

    @Test
    void checkAndPrint_whereClass2() {
        CheckCamelCase.checkAndPrint(Class2.class);
    }

    @Test
    void checkMatchers_camelCase() {
        String camelCasePattern = "^[a-z]+([A-Z][a-z0-9]+)+";
        boolean val;

        val = "camelCase".matches(camelCasePattern);
        System.out.println("val = " + val);

        val = "camelCaseCase".matches(camelCasePattern);
        System.out.println("val = " + val);

        val = "JustMethod".matches(camelCasePattern);
        System.out.println("val = " + val);
    }

    @Test
    void checkMatchers_lowerCaseWord() {
        String camelCasePattern = "^[a-z]+$";
        boolean val;

        val = "camelcamelcamelcamel".matches(camelCasePattern);
        System.out.println("val = " + val);

        val = "_camel".matches(camelCasePattern);
        System.out.println("val = " + val);
    }
}