package InnerClasses;

public class Subclass {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Nested nested = outer.new Nested();
        // Nested class does not have access to members of parent class
        // nested.a();
        nested.b();

        Child child = new Child();
        child.a();
        child.c();
    }
}

class Outer {

    public void a() {
        System.out.println("A called");
    }

    public class Nested {

        public void b() {
            System.out.println("B called");
        }
    }

}

class Child extends Outer {
    public void c() {
        System.out.println("C called");
    }
}