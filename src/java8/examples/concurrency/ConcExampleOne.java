package java8.examples.concurrency;

import sun.misc.IOUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ConcExampleOne {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40);
        list.stream().map(i-> CompletableFuture.supplyAsync(()->getNumber(i)))       // returns CompletableFuture<Integer>
                .map(compFuture->compFuture.thenApply(n->n*n))
                .map(t->t.join())                           // join returns the result after completion or throws CompletionException. It waits for the completion of calling completion stage.
                .forEach(s->System.out.println(s));

    }
    public static Integer getNumber(Integer a){
        return a*a;
    }
}

/*


 */