package GC;

public class FinalizeMethod {
    public static void main(String[] args) {
        String str = new String("abc");
        str = null;

        System.gc();
        System.out.println("Main Method completes");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("FinalizeMethod : Finalize Method Called");
    }
}
