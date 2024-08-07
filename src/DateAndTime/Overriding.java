package DateAndTime;

public class Overriding {
    public static void main(String[] args) {

        Car car = new Car();
        System.out.println(car.a);
        car.start();
        Car.end();
        System.out.println("****************************");

        // Up casting
        Car car2 = new SportsCar();
        System.out.println(car2.a);
        car2.start();
        Car.end(); // Method Hiding
        System.out.println("****************************");

        SportsCar car3 = new SportsCar();
        System.out.println(car3.a);
        car3.start();
        SportsCar.end();

        Car car4 = new Car(40);
        Car car5 = new SportsCar(50);
        SportsCar car6 = new SportsCar(60);

    }
}

class Car {

    int a;

    public Car() {
        System.out.println("Parent Car() constructor called");
        a = 10;
    }

    public Car(int a) {
        System.out.println("Parent Car(int a) constructor called");
        this.a = a;
    }

    public void start() {
        System.out.println("Parent Car started");
    }

    public static void end() {
        System.out.println("Parent Car ended");
    }

}

class SportsCar extends Car {

    int a;

    public SportsCar() {
        super();
        System.out.println("Child SportsCar() constructor called");
        this.a = 20;
    }

    public SportsCar(int a) {
        System.out.println("Child SportsCar(int a) constructor called");
        this.a = a;
    }

    @Override
    public void start() {
        System.out.println("Child SportsCar started");
    }

    // @Override
    public static void end() {
        System.out.println("Child SportsCar ended");
    }

}
