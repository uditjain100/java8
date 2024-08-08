package Interfaces;

public class Inheritance {
    public static void main(String[] args) {
        Parent p = new ChildClass();
        p.fun1();
        p.fun2();
        Parent.fun3();
        // p.fun3() // not visible

        Child c = new ChildClass();
        c.fun1();
        c.fun2();
        Child.fun3();
        // c.fun3() // not visible

        ChildClass cc = new ChildClass();
        cc.fun1();
        cc.fun2();
        ChildClass.fun3(); // similar to cc.fun3();

    }
}

interface Parent {
    void fun1();

    default void fun2() {
        System.out.println("Parent fun2 called");
    }

    static void fun3() {
        System.out.println("Parent fun3 called");
    }
}

interface Child extends Parent {
    void fun1();

    @Override
    default void fun2() {
        System.out.println("Child fun2 called");
    }

    // New Method of interface B
    static void fun3() {
        System.out.println("Child fun3 called");
    }
}

class ChildClass implements Child {

    @Override
    public void fun1() {
        System.out.println("ChildClass fun1 called");
    }

    @Override
    public void fun2() {
        System.out.println("ChildClass fun2 called");
    }

    // New Method of Child Class
    public static void fun3() {
        System.out.println("ChildClass fun3 called");
    }

}