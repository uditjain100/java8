package MethodReference;

public class ConstructorReference {
    public static void main(String[] args) {
        Generator generator = RollNumberGenerator::new;
        System.out.println(generator.generate(25).rollNo);
    }
}

@FunctionalInterface
interface Generator {
    RollNumberGenerator generate(int id);
}

class RollNumberGenerator {
    int rollNo;

    RollNumberGenerator(int num) {
        this.rollNo = num;
    }
}