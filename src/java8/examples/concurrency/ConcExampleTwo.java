package java8.examples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ConcExampleTwo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D");
        list.stream()
                .map(data-> CompletableFuture.supplyAsync(()->"Processing:"+data))
                .map(compFuture->compFuture.thenAccept(s->System.out.println(s)))
                .map(t->t.join())
                .count();
    }
}

//thenAccept expects Consumer and applies it on the result and returns CompletableFuture.