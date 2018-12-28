package java8.examples.defaultMethods;

interface Mammal {
    String identifyMyself();
}
class FeralHorse {
    public String identifyMyself() {
        return "I am a feral horse.";
    }
}
public class Mustang extends FeralHorse implements Mammal {
    public static void main(String[] args) {
        Mustang myApp = new Mustang();
        System.out.println(myApp.identifyMyself());
    }
}
