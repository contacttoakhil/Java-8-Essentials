package java8.examples.defaultMethods;

class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}
interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

public class Pegasus extends Horse implements Flyer {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}

