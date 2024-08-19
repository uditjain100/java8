package MultiThreading;

public class LifeCycle extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LifeCycle myThread1 = new LifeCycle();
        System.out.println(myThread1.getState());
        myThread1.start();
        System.out.println(myThread1.getState());
        Thread.sleep(100);
        System.out.println(myThread1.getState());
        myThread1.join();
        System.out.println(myThread1.getState());

    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
