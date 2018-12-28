package java8.examples.Optional.streams;

import java.util.Optional;

public class Car {
    private String modelDetails;
    private Optional<Insurance> insurance;

    public Car(String modelDetails, Insurance insurance) {
        this.modelDetails = modelDetails;
        this.insurance = Optional.ofNullable(insurance);
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelDetails='" + modelDetails + '\'' +
                ", insurance=" + insurance.get().getName() +
                '}';
    }
}
