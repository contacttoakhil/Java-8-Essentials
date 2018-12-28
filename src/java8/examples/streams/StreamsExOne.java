package java8.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExOne {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream().forEach(System.out::println);
        Stream.of("1","2","3","4").forEach(System.out::println);
        IntStream.iterate(0,i->i+2).limit(5).forEach(System.out::println); //infinite stream
    }
}
