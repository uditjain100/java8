package Generics;

import java.io.Serializable;

public class Employee {

    public static void main(String[] args) {
        Manager<String, Integer, Integer> manager = new Manager<>("John Doe", 123, new Integer[] { 85, 90, 88 });
        System.out.println("Name: " + manager.getName());
        System.out.println("Name Type: " + Manager.getNameType(manager.getName()));
        manager.printMarks();

        CEO<String, Integer, Integer> ceo = new CEO<>("Oliver", 12345, new Integer[] { 805, 900, 808 });
        ceo.manageProjects();
        ceo.printMarks();
    }
}

class Manager<T extends Object & Serializable, V extends Number, K extends Number & Serializable & Comparable>
        extends Employee {

    T name;
    K id;
    V[] marks;

    public Manager(T name, K id, V[] marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public T getName() {
        return this.name;
    }

    public void setName(T name) {
        this.name = name;
    }

    // can be declared in non generic classes
    public static <T> String getNameType(T name) {
        return name.getClass().getName();
    }

    public void printMarks() {
        for (V mark : this.marks)
            System.out.println(mark);
    }

}

class CEO<T extends Object & Serializable, V extends Number, K extends Number & Serializable & Comparable>
        extends Manager<T, V, K> {

    public CEO(T name, K id, V[] marks) {
        super(name, id, marks);
    }

    public void manageProjects() {
        System.out.println("Managing projects");
    }

}
