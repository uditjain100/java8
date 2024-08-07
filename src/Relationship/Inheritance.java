package Relationship;

public class Inheritance {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}

class A {
    public int a = 10;

    public void show() {
        System.out.println("show() in A");
    }
}

class B extends A {

    public int a = 20;

    @Override
    public void show() {
        System.out.println("show() in B");
    }
}