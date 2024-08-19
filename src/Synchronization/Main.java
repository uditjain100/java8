package Synchronization;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCount());

    }
}

class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void increment() {
        synchronized (this) { // ensures mutual exclusion and visibility
            this.count++;
        }
    }

    public int getCount() {
        return this.count;
    }
}

class MyThread extends Thread {

    public Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            this.counter.increment();
    }

}