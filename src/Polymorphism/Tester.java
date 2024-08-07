package Polymorphism;

public class Tester {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.s);
        car.speed();
        car.speed(30);
        // The method speed(int) in the type Car is not applicable for the arguments
        // (double)
        // car.speed(8.3);
        Car.speed("Abc");
        Car.speed(70, "Abc");
    }
}

class Car {

    int s;

    public Car() {
        System.out.println("Parent Car() called");
        s = 10;
    }

    public Car(int b) {
        System.out.println("Parent Car(int b) called");
        this.s = b;
    }

    public void speed() {
        System.out.println("Parent speed() called");
    }

    public void speed(int a) {
        System.out.println("Parent speed(int a) called");
    }

    public static void speed(String str) {
        System.out.println("Parent static speed(String str) called");
    }

    public static void speed(int a, String str) {
        System.out.println("Parent static speed(int a, String str) called");
    }

}

class SportCar extends Car {
    int s;

    public SportCar() {
        // super(); -> don't have to specify explicitly as it is specified implicitly
        System.out.println("Child SportsCar() called");
        this.s = 20;
    }

    public SportCar(int b) {
        super(b);
        System.out.println("Child SportsCar(int b) called");
    }

    @Override
    public void speed() {
        System.out.println("Child speed() called");
    }

    @Override
    public void speed(int a) {
        System.out.println("Child speed(int a) called");
    }

}