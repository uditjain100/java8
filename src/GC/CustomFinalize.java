package GC;

public class CustomFinalize {
    public static void main(String[] args) {
        CustomFinalize customFinalize = new CustomFinalize();

        customFinalize.finalize();
        customFinalize.finalize();

        customFinalize = null;
        System.gc();

        System.out.println("Main Method completes");
    }

    public void finalize() {
        System.out.println("CustomFinalize : Custom Finalize Method Called");
    }
}
