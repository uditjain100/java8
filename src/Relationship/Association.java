package Relationship;

import java.util.List;

public class Association {
    public static void main(String[] args) {

    }
}

class Student {
}

class Teacher {
}

class College {
    List<Student> students;
    List<Teacher> teachers;
}

class Engine {
}

class Tyre {
}

class Vehicle {
    Engine engine;
    List<Tyre> tyres;
}