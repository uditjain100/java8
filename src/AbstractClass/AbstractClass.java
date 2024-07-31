package AbstractClass;

abstract class LivingBeing {
    int a;

    LivingBeing() {
        a = 10;
    }

    abstract void talk();

    public void tester() {
        System.out.println("Living Being Tester called ... ");
    }

    public static void updateCountLivingBeings() {

    }

    public static void main(String[] args) {
        System.out.println("Living Being Main method called ... ");
    }

}

abstract class Human extends LivingBeing {
    static int count;

    Human() {
        Human.count = 0;
    }

    abstract void work();

    public void tester() {
        System.out.println("Human Tester called ... ");
    }

    public static void updateCountLivingBeings() {
        Human.count++;
    }

    public final void eat() {
        System.out.println("Human eats ... ");
    }
}

class Man extends Human {

    @Override
    void talk() {
        System.out.println("Man talks");
    }

    @Override
    void work() {
        System.out.println("Man works");
    }

}

class Women extends Human {

    @Override
    void talk() {
        System.out.println("Women talks");
    }

    @Override
    void work() {
        System.out.println("Women works");
    }

}

public class AbstractClass {
    public static void main(String[] args) {
        // We can't create an instance of abstract class
        // LivingBeing liv = new LivingBeing();

        LivingBeing man = new Man();
        man.talk();
        // work() method can't be accessed as reference variable decides which methods
        // should be exposed
        // man.work();
        System.out.println(man.a);

        Human women = new Women();
        women.talk();
        women.work();
        System.out.println(women.a);

        Human.updateCountLivingBeings();
        Human.updateCountLivingBeings();
        System.out.println("Count : " + Human.count);
    }
}
