package task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase {}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

class Class1{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void InCorrect(){}
    @CamelCase
    public void JustMethod(){}
}

class Class2{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void oneMoreCorrect(){}
}

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "^[a-z]+([A-Z][a-z0-9]+)+";
    public static final String LOWERCASE_PATTERN = "^[a-z]+$";

    public static boolean checkAndPrint(Class<?> c){
        boolean hasBad = false;
        for(Method m : c.getDeclaredMethods()){
            m.setAccessible(true);
            if(m.isAnnotationPresent(CamelCase.class)
                    && ! m.getName().matches(CAMELCASE_PATTERN)
                    && ! m.getName().matches(LOWERCASE_PATTERN)) {
                System.out.printf("method %s.%s doesn't satisfy camelCase naming" +
                        " convention\n", c.getName(), m.getName());
                hasBad = true;
            }
        }
        return !hasBad;
    }
}