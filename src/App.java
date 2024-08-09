public class App {

    int a = 10;

    {
        a = 20;
    }

    public App() {
        this.a = 30;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        App app = new App();
        System.out.println(app.a);
    }

}
