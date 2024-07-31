package instanceOf;

class Parent {
}

class Child extends Parent {

}

public class InsatnceOf {
    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();

        System.out.println(p instanceof Parent);
        System.out.println(p instanceof Child);
        System.out.println(c instanceof Parent);
        System.out.println(c instanceof Child);
        System.out.println(pc instanceof Parent);
        System.out.println(pc instanceof Child);

        Parent pn = null;
        Child cn = null;
        System.out.println(pn instanceof Parent);
        System.out.println(pn instanceof Child);
        System.out.println(pn instanceof Object);
        System.out.println(cn instanceof Parent);
        System.out.println(cn instanceof Child);
        System.out.println(cn instanceof Object);
    }
}
