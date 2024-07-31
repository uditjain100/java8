package immutableClass;

import java.util.*;

public final class Student {

    private final String name;
    private final int age;
    private final List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = new ArrayList<>(subjects); // deep copy
    }

    public String getName() {
        return new String(this.name); // return deep copy of name
    }

    public int getAge() {
        return this.age;
    }

    public List<String> getSubjects() {
        return new ArrayList<>(this.subjects); // return deep copy of subjects
    }

    @Override
    public String toString() {

        return "Student : " + this.getClass().hashCode() + " -> {" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", subjects=" + getSubjects() +
                '}';
    }

}

class Tester {
    public static void main(String[] args) {
        String name = "abhimanyu";
        int age = 22;
        List<String> subjects = new ArrayList<>(Arrays.asList("Math", "Science", "English"));
        Student student = new Student(name, age, subjects);

        System.out.println(student);

        name = "Abhinav";
        subjects.add("Computer Science");

        System.out.println(student);

        String studentName = student.getName();
        List<String> studentSubjects = student.getSubjects();

        studentName = "Rohan";
        studentSubjects.add("Mechanics");

        System.out.println(student);

    }
}
