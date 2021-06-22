package task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestSuite {
    String[] value();
}

class TestSuitHandler {
    @SuppressWarnings("unchecked")
    public static void run(Class<?> clazz) {
        String className = clazz.getName();
        int lastDot = className.lastIndexOf(".");
        String simpleClassName = className.substring(lastDot + 1);

        if (! clazz.isAnnotationPresent(TestSuite.class)) {
            System.out.printf("Class %s isn't annotated\n", simpleClassName);
            return;
        }

        //get names of methods from TestSuite.value
        for (String methodName : clazz.getAnnotation(TestSuite.class).value()) {
            try {
                Method method = clazz.getMethod(methodName);
                if(Modifier.isStatic(method.getModifiers())) {
                    System.out.printf("Method with name %s doesn't exists or not public in class %s\n", methodName, simpleClassName);
                } else {
                    System.out.printf("\t-- Method %s.%s started --\n", simpleClassName, methodName);
                    method.invoke(clazz.getConstructor().newInstance());
                    System.out.printf("\t-- Method %s.%s finished --\n", simpleClassName, methodName);
                }
            } catch (NoSuchMethodException e) {
                System.out.printf("Method with name %s doesn't exists or not public in class %s\n", methodName, simpleClassName);
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}

@TestSuite({"m1", "m2", "m3", "m4", "m5", "m6"})
class Class1{

    public Class1(){}

    //m1 method not exists

    public void m2(){
        System.out.println("m2 - correct method");
    }

    public static void m3(){
        System.out.println("m3 - static method");
    }

    public void m4(){
        System.out.println("m4 - correct method");
    }

    public void m5(String s){
        System.out.println("m5 - method with param");
    }

    private void m6(){
        System.out.println("m6 - private method");
    }

}

class Class2{}