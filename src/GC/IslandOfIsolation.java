package GC;

public class IslandOfIsolation {

    IslandOfIsolation ref;

    public static void main(String[] args) {

        IslandOfIsolation a = new IslandOfIsolation();
        IslandOfIsolation b = new IslandOfIsolation();

        a.ref = b;
        b.ref = a;

        a = null;
        b = null;

        System.gc();
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("Finalize Called");
    }

}