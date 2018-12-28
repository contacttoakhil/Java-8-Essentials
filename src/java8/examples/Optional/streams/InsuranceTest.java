package java8.examples.Optional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class InsuranceTest {
    public static void main(String[] args) {

        String insuranceName = getCarInsuranceName(Optional.of(new Person("Kuldeep", new Car("Nissan Terrano", new Insurance("Aegon Religare")))));
        System.out.println("Insurance Name: " + insuranceName);

        Optional<Car> taxi = rideTaxiJava8();
        if(taxi.isPresent())
            System.out.println("Taxi Details: " + taxi.get());
    }

    /***
     * Get insurance details for person
     * @param person
     * @return name of insurance company
     */
    public static String getCarInsuranceName(Optional<Person> person)
    {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    /****
     * stream through all persons and fetch the first one with a car.
     * @return Optional<Car>
     */
    private static Optional<Car> rideTaxiJava8()
    {
        return getPeople().stream()
                .map(Person::getCar)
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .findFirst();
    }

    /*
    private static Optional<Car> rideTaxiJava9()
    {
        return getPeople().stream()
                .map(Person::getCar)
                .flatMap(Optional::stream)
                .findFirst();
    }*/

    private static List<Person> getPeople()
    {
        List<Person> personList = Arrays.asList(
                new Person("Ram", null),
                //new Person("John", new Car("Fiat 85", null)),
                new Person("Akash", new Car("Ford Mustang", new Insurance("InsuranceTwo"))),
                new Person("Sandeep", new Car("VW Polo", new Insurance("InsuranceOne"))),
                new Person("Kuldeep", new Car("Nissan Terrano", new Insurance("InsuranceTwo"))),
                new Person("Shaun", new Car("Maruti Swift", new Insurance("InsuranceOne")))
                );
        return personList;
    }
}
