package HelloGradle;

public class App {

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        String name = System.getProperty("name");
        String greeting = greeter.greet(name);
        System.out.println(greeting);
    }
}
