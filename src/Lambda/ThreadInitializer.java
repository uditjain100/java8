package Lambda;

public class ThreadInitializer {
    public static void main(String[] args) {

        ThreadRunner threadRunner = new ThreadRunner();
        Thread thread1 = new Thread(threadRunner);
        thread1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous Thread");
            }
        };

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(() -> System.out.println("Hello from Lambda Thread"));
        thread3.start();

    }
}

class ThreadRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from ThreadRunner");
    }
}