package Lambda;

public class LambdaCronology {
    public static void main(String[] args) {

        // Method 1 - Explicit Class
        TaskRunner runner1 = new TaskRunner();
        runner1.performTask();

        // Method 2 - Anonymous Inner Class
        Flexible runner2 = new Flexible() {
            @Override
            public void performTask() {
                System.out.println("Running a task...");
            }
        };
        runner2.performTask();

        // Method 3 - Lambda Expression
        Flexible runner3 = () -> System.out.println("Running a task...");
        runner3.performTask();

    }
}

interface Flexible {
    void performTask();
}

class TaskRunner implements Flexible {
    @Override
    public void performTask() {
        System.out.println("Running a task...");
    }
}
