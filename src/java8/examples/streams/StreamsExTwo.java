package java8.examples.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsExTwo {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()                             //Calling the method stream() on a bunch of objects returns a regular object stream. But we don't need collection to work with streams.
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        myList.stream().forEach(System.out::println);
    }
}
