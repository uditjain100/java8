package Relationship;

public class Types {
    public static void main(String[] args) {

    }
}

class SingleLevel {
    class A {
    }

    class B extends A {
    }
}

class MultiLevel {
    class A {
    }

    class B extends A {
    }

    class C extends B {
    }
}

class Hierarchical {
    class A {
    }

    class B1 extends A {
    }

    class B2 extends A {
    }

    class B3 extends A {
    }
}

class Multiple {
    interface A1 {
    }

    interface A2 {
    }

    interface A3 {
    }

    class B implements A1, A2, A3 {
    }
}

class Hybrid {
    interface A {
    }

    interface B1 extends A {
    }

    interface B2 extends A {
    }

    class C implements B1, B2 {
    }
}