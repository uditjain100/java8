package GC;

public class ExceptionFinalize {
    public static void main(String[] args) {
        ExceptionFinalize obj = new ExceptionFinalize();

        // obj.finalize();

        obj = null;
        System.gc();
        System.out.println("Main Method Completes");
    }

    @Override
    public void finalize() {
        System.out.println("ExceptionFinalize : Finalize Method Called");
        System.out.println(10 / 0);
    }
}
