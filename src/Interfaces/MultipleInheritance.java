package Interfaces;

public class MultipleInheritance {
    public static void main(String[] args) {

    }
}

interface A {
    void display();
}

interface B1 extends A {
    void show();
}

interface B2 extends A {
    void traverse();
}

class C implements B1, B2 {
    @Override
    public void display() {
        System.out.println("Displaying from C");
    }

    @Override
    public void show() {
        System.out.println("Showing from C");
    }

    @Override
    public void traverse() {
        System.out.println("Traversing from C");
    }
}
