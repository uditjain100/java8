package Interfaces;

public class InterfaceIntro {
    public static void main(String[] args) {

    }
}

interface Human {
    // By default public, static, final
    int EYES_COUNT = 2;

    // By default public, abstract
    void speak();

    // By default public
    default void eat() {
        System.out.println("Human eat");
    }

    // By default public
    static void walk() {
        System.out.println("Human walk");
    }
}

abstract class Man implements Human {

}

class Indian extends Man {
    @Override
    public void speak() {
        System.out.println("Indian speak");
    }
}