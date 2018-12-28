package java8.examples.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExampleOne {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                Thread.sleep(1);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("task completed");
            } else {
                System.out.println("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
    StampedLock also supports read and write like ReadWriteLock but locking method returns a stamp (long value) which is used to release a lock
    or to check if a lock is valid. It also provide lock mode called optimistic locking.
    StampedLock is not renentrant in nature - Each call to lock returns a new stamp and blocks if no lock is available even if the same thread already holds a lock. So we have
    to pay particular attention not to run into deadlocks.

    Both read tasks will wait until write is done and lock has been released. Then both read tasks print to the console simultaneously because multiple reads doesn't block each other
    as long as no write-lock is held.
 */
