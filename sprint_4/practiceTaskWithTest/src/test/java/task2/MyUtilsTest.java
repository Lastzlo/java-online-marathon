package task2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    @Test
    void commonStudents_checkNullString() {
        List<MyUtils.Student> list1 = Arrays.asList(
                new MyUtils.Student(1,"Ivan"),
                new MyUtils.Student(2,"Ann"),
                new MyUtils.Student(3,null));

        List<MyUtils.Student> list2 = Arrays.asList(
                new MyUtils.Student(1,"Ivan"),
                new MyUtils.Student(2,"Ann"),
                new MyUtils.Student(4,"Gleb"));

        Set<MyUtils.Student> set = new MyUtils().commonStudents(list1, list2);

        assertEquals(2, set.size());
        for (MyUtils.Student student : set) {
            System.out.println("student = " + student);
        }
    }

    @Test
    void commonStudents_checkNullString2() {
        List<MyUtils.Student> list1 = Arrays.asList(
                new MyUtils.Student(3,null));

        List<MyUtils.Student> list2 = Arrays.asList(
                new MyUtils.Student(3,null));

        Set<MyUtils.Student> set = new MyUtils().commonStudents(list1, list2);

        assertEquals(1, set.size());
        for (MyUtils.Student student : set) {
            System.out.println("student = " + student);
        }
    }

    @Test
    void commonStudents() {
        List<MyUtils.Student> list1 = Arrays.asList(
                new MyUtils.Student(1,"Ivan"),
                new MyUtils.Student(2,"Ann"),
                new MyUtils.Student(3,"Victor"));

        List<MyUtils.Student> list2 = Arrays.asList(
                new MyUtils.Student(1,"Ivan"),
                new MyUtils.Student(2,"Ann"),
                new MyUtils.Student(4,"Gleb"));

        Set<MyUtils.Student> set = new MyUtils().commonStudents(list1, list2);
        
        assertEquals(2, set.size());
        for (MyUtils.Student student : set) {
            System.out.println("student = " + student);
        }

    }
}