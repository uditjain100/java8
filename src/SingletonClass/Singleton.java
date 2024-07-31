package SingletonClass;

public class Singleton {
    public static void main(String[] args) {

        Daemon daemon1 = Daemon.getInstance();
        Daemon daemon2 = Daemon.getInstance();

        daemon1.testValue++;
        System.out.println(daemon1.testValue);
        System.out.println(daemon2.testValue);
    }
}

class Daemon {

    private static Daemon daemon;
    int testValue;

    private Daemon() {
        daemon = null;
        this.testValue = 0;
    }

    public static Daemon getInstance() {
        if (daemon == null)
            return daemon = new Daemon();
        return daemon;
    }

}
