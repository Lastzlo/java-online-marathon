package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyUtilsTest {

    //For example, for a given list
    //[ Person [name=Ivan],
    //  Student [name=Petro, studyPlace=University, studyYears=3],
    //  Worker [name=Andriy, workPosition=Developer, experienceYears=12],
    //  Student [name=Stepan, studyPlace=College, studyYears=4],
    //  Worker [name=Ira, workPosition=Manager, experienceYears=8],
    //  Student [name=Ihor, studyPlace=University, studyYears=4]
    //]
    //you should get
    //[ Worker [name=Andriy, workPosition=Developer, experienceYears=12],
    //  Student [name=Stepan, studyPlace=College, studyYears=4],
    //  Student [name=Ihor, studyPlace=University, studyYears=4]]
    @Test
    void maxDuration_whenTestExampleDate() {
        //give
        List<Person> personList = new ArrayList<>(){{
            add(new Person("Ivan"));
            add(new Student("Petro", "University", 3));
            add(new Worker("Andriy", "Developer", 12));
            add(new Student("Stepan", "College", 4));
            add(new Worker("Ira", "Manager", 8));
            add(new Student("Ihor", "University", 4));
        }};

        //when
        final List<Person> resultList = new MyUtils().maxDuration(personList);

        //then
        Assertions.assertEquals(3,  resultList.size());

    }

    @Test
    void maxDuration_whenDuplicatePersons() {
        //give
        List<Person> personList = new ArrayList<>(){{
            add(new Person("Ivan"));
            add(new Person("Ivan"));
            add(new Person("Ivan"));
            add(new Student("Petro", "University", 3));
            add(new Student("Petro", "University", 3));
            add(new Student("Petro", "University", 3));
            add(new Worker("Andriy", "Developer", 12));
            add(new Worker("Andriy", "Developer", 12));
            add(new Worker("Andriy", "Developer", 12));
            add(new Student("Stepan", "College", 4));
            add(new Student("Stepan", "College", 4));
            add(new Student("Stepan", "College", 4));
            add(new Worker("Ira", "Manager", 8));
            add(new Student("Ihor", "University", 4));
        }};

        //when
        final List<Person> resultList = new MyUtils().maxDuration(personList);

        //then
        Assertions.assertEquals(3,  resultList.size());

    }
}