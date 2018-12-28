package java8.examples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

public class StampedLockExampleTwo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });
        stop(executor);
    }
    private static void stop(ExecutorService executor) {
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("task completed");
            } else {
                System.out.println("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // log it.
        }
    }
}

/* This example demonstrates optimistic locking.
An optimistic read lock is acquired by calling tryOptimisticRead() which always returns a stamp without blocking the current thread, no matter if the lock is actually available.
If there's already a write lock active the returned stamp equals zero. We can always check if a stamp is valid by calling lock.validate(stamp).
----
Optimistic Lock Valid: true
Write Lock acquired
Optimistic Lock Valid: false
Write done
Optimistic Lock Valid: false
Forcing shutdown...
----
The optimistic lock is valid right after acquiring the lock. In contrast to normal read locks an optimistic lock doesn't prevent other threads to obtain a write lock instantaneously.
After sending the first thread to sleep for one second the second thread obtains a write lock without waiting for the optimistic read lock to be released. From this point the
optimistic read lock is no longer valid. Even when the write lock is released the optimistic read locks stays invalid.

So when working with optimistic locks we have to validate the lock every time after accessing any shared mutable variable to make sure the read was still valid.
*/
