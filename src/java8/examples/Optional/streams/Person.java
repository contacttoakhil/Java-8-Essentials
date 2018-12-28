package java8.examples.Optional.streams;

import java.util.Optional;

public class Person {
    private String name;
    private Optional<Car> car;

    public Person(String name, Car car) {
        this.name = name;
        this.car = Optional.ofNullable(car);
    }

    public Optional<Car> getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
