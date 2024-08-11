package MethodReference;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Method Reference
        List<Student> students = Arrays.asList(new Student("A", 1, 1), new Student("B", 1, 2), new Student("C", 1, 3));
        // Static Reference
        Collections.sort(students, ComparisonProvider::compareByName); // (a, b) -> ComparisonProvider.compareByName(a,
                                                                       // b)
        System.out.println(students);
        // Non - Static Reference
        Collections.sort(students, new ComparisonProvider()::compareByAge); // (a, b) -> new
                                                                            // ComparisonProvider().compareByAge(a, b)
        System.out.println(students);
        // Non - Static Reference of arbitrary object of particular type
        students.stream().map(Student::getId).collect(Collectors.toList()).forEach(System.out::print); // ele ->
                                                                                                       // ele.getId()
        System.out.println();
        // Constructor Reference
        Functional functional = FunctionalClass::new; // new FunctionalClass();
        functional.execute();
    }
}

interface Functional {
    void execute();
}

class FunctionalClass {
    FunctionalClass() {
        System.out.println("FunctionalClass execute method called");
    }
}

class ComparisonProvider {

    public int compareByAge(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }

    public static int compareByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    public static int compareById(Student s1, Student s2) {
        return s1.getId() - s2.getId();
    }

}

class Student {
    private String name;
    private int age;
    private int id;

    public Student() {
        this.name = "Student";
        this.age = 0;
        this.id = 0;
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
