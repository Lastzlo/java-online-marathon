package task3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class TestSuitHandlerTest {

    @Test
    void run_whenClassWithAnnotation() {
        //give Class1.class
        TestSuitHandler.run(Class1.class);
    }

    @Test
    void run_whenClassWithoutAnnotation() {
        //give Class2.class
        TestSuitHandler.run(Class2.class);
        //then "Class Class2 isn't annotated\n"
    }

    @Test
    void createInstanceOfClass1() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("task3.Class1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<?> ctor = null;
        try {
            ctor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Object object = ctor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        try {
//            final Object obj = Class1.class.getConstructor().newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void createInstanceOfClass1_2() {
        try {
            final Object obj = Class1.class.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void cutOnlyClassNameWithoutPackage() {
        System.out.println("Class1.class = " + Class1.class);
        
        String className = Class1.class.getName();
        System.out.println("className = " + className);
        
        int lastDot = className.lastIndexOf(".");
        String simpleClassName = className.substring(lastDot + 1);
        System.out.println("simpleClassName = " + simpleClassName);

        //simplify
        className = Class1.class.getName()
                .substring(Class1.class.getName().lastIndexOf(".") + 1);
        System.out.println("className = " + className);
    }
}