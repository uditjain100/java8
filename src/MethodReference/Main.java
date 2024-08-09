package MethodReference;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Method Reference
        List<Student> students = Arrays.asList(new Student("A", 1, 1), new Student("B", 1, 2), new Student("C", 1, 3));
        // Static
        students.stream().map(st -> st.getDetails()).forEach(System.out::println);
        // Non - Static
        students.stream().map(Student::getName).forEach(System.out::println);
        // Constructor
        students.stream().map(Student::getId).map(ArrayList::new).forEach(System.out::println);
        students.stream().map(Student::getId).collect(Collectors.toList()).forEach(System.out::println);
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

    public String getDetails() {
        return "Student Details : " + this.name + " " + this.age + " " + this.id;
    }

    public static void printDetails() {
        System.out.println("Student Details");
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
}
