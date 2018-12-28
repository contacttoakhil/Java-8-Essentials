package java8.examples.defaultMethods;

interface OperateCar {
    default public void startEngine(Object key) {
        System.out.println("Starting Engine in OperateCar");
        // implementation logic
    }
}
interface FlyCar {
    default public void startEngine(Object key) {
        System.out.println("Starting Engine in FlyCar");
        // implementation logic
    }
}
class FlyingCarHelper implements OperateCar,FlyCar {
   public void startEngine(Object key) {
        //FlyCar.super.startEngine(key);
        //OperateCar.super.startEngine(key);
    }
}
public class FlyingCar {
    public static void main(String[] args) {
        FlyingCarHelper flyingCarHelper = new FlyingCarHelper();
        flyingCarHelper.startEngine(new Object());
    }
}


