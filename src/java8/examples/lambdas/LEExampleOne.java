package java8.examples.lambdas;

public class LEExampleOne {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Java");
            }
        };
        Runnable r2 = () -> System.out.println("Hello Java 8");
        r1.run();
        r2.run();
    }
}
