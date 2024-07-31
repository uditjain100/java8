package Interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        Student s1 = new Student(1, "John", 20);
        Student s2 = new Student(2, "Alice", 18);
        Student s3 = new Student(3, "Bob", 22);
        Student s4 = new Student(4, "Rong", 24);

        Student[] students = { s2, s1, s3, s4 };

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new NameComparator());
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new AgeComparator());
        System.out.println(Arrays.toString(students));

    }
}

class Student implements Comparable<Student> {
    int id;
    String Name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.Name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.Name.compareTo(o2.Name);
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
