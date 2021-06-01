package task2;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//Create the commonStudents() method of the MyUtils class to return a HashSet of common elements of two student lists.
//
//For example, for a given
//
//list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
//
//and
//
//list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]
//
//you should get
//
//[Students [id=3, name=Stepan], Students [id=1, name=Ivan]]
public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, metthods, Code
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId(){
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof Student)) return false;
            Student s = (Student) o;
            if (id != s.id) return false;
            if (name == null && s.name == null) return true;
            if (name != null && s.name != null) return (name.equals(s.name));
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "{Student: id = " + id +
                    " name = " + name +
                    "}";

        }

    }


    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> set = new HashSet<>();

        for(Student s1 : list1) {
            if (list2.contains(s1)) set.add(s1);
        }
        return set;
    }


}
