package Instances;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class Tester {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal = new Dog();
        animal = new Cat();
    }
}

public class Instance {

    public static class Employee implements Cloneable, Serializable {
        String name;

        public Employee() {
            this.name = "Joey";
        }

        @Override
        public Employee clone() throws CloneNotSupportedException {
            return (Employee) super.clone();
        }
    }

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException,
            NoSuchMethodException, InvocationTargetException, IOException {
        Employee e1 = new Employee();
        String e2 = (String) Class.forName("java.lang.String").newInstance();
        Employee e3 = (Employee) e1.clone();
        Employee e4 = Employee.class.getConstructor(null).newInstance();
        new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\ccs\\Documents\\java8\\src\\Instances\\object")).writeObject(e2);
        Object e5 = (Object) new ObjectInputStream(
                new FileInputStream("C:\\Users\\ccs\\Documents\\java8\\src\\Instances\\object")).readObject();

        System.out.println(e1 instanceof Employee);
        System.out.println(e2 instanceof String);
        System.out.println(e3 instanceof Employee);
        System.out.println(e4 instanceof Employee);
        System.out.println(e5 instanceof Object);

    }

}