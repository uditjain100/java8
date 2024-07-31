package Interfaces;

public class DiamondAndDefault {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.speak();
    }
}

interface Dog {
    default void speak() {
        System.out.println("Dog Speaks");
    }
}

interface Cat {
    default void speak() {
        System.out.println("Cat Speaks");
    }
}

class Pet implements Dog, Cat {
    public void speak() {
        Dog.super.speak();
    }
}