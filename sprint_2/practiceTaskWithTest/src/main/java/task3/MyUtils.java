package task3;

import java.util.*;

//task3
//Create next types: Person (field String name), Student (fields String studyPlace, int studyYears) and Worker (fields String workPosition, int experienceYears). Classes Student and Worker are derived from class Person. All classes have getters to return fields.
//Create a maxDuration() method of the MyUtils class to return a list of Students with maximum duration of study and Workers with maximum experience.
//For example, for a given list
//[Person [name=Ivan], Student [name=Petro, studyPlace=University, studyYears=3], Worker [name=Andriy, workPosition=Developer, experienceYears=12], Student [name=Stepan, studyPlace=College, studyYears=4], Worker [name=Ira, workPosition=Manager, experienceYears=8], Student [name=Ihor, studyPlace=University, studyYears=4]]
//you should get
//[Worker [name=Andriy, workPosition=Developer, experienceYears=12], Student [name=Stepan, studyPlace=College, studyYears=4], Student [name=Ihor, studyPlace=University, studyYears=4]]

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears && Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studyPlace, studyYears);
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears && Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPosition, experienceYears);
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Student> studentList = new ArrayList<>();
        List<Worker> workerList = new ArrayList<>();

        Set<Person> personSet = new HashSet<>();

        for (Person person : persons) {
            if (person instanceof Student) studentList.add((Student) person);
            if (person instanceof Worker) workerList.add((Worker) person);
        }

        Comparator<Worker> byExperience =
                Comparator.comparingInt(Worker::getExperienceYears);

        Collections.sort(workerList, byExperience);

        if (!workerList.isEmpty()) {
            Worker bestWorker = workerList.get(workerList.size() -1);
            personSet.add(bestWorker);

            for (Worker worker : workerList) {
                if (worker.getExperienceYears() == bestWorker.getExperienceYears()) {
                    personSet.add(worker);
                }
            }
        }

        Comparator<Student> byStudyYears =
                Comparator.comparingInt(Student::getStudyYears);

        Collections.sort(studentList, byStudyYears);

        if (!studentList.isEmpty()) {
            Student bestStudent = studentList.get(studentList.size() -1);
            personSet.add(bestStudent);

            for (Student student : studentList) {
                if (student.getStudyYears() == bestStudent.getStudyYears()) {
                    personSet.add(student);
                }
            }
        }

        List<Person> resultList = new ArrayList<>(personSet);

        return resultList;
    }

    //getUniquePersonInListByCompare

}