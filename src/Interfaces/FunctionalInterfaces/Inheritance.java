package Interfaces.FunctionalInterfaces;

public class Inheritance {
    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface Parent {
    void execute();
}

@FunctionalInterface
interface Child1 extends Parent {
    void execute();
}

@FunctionalInterface
interface Child2 extends Parent {
}