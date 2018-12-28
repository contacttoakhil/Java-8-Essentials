package java8.examples.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExThree {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);  // a1. We can just use Stream.of()
        IntStream.range(1, 4).forEach(System.out::println); //IntStreams can replace the regular for-loop using range().
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
    }
}
