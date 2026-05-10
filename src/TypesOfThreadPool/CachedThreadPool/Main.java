package TypesOfThreadPool.CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("Submitting tasks to a Cached Pool: ");

        for (int i = 1; i <= 30; i++)
        {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task running by " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        Thread.sleep(5000);
        System.out.println("\nAll tasks submitted. Cached Pool will terminate idle threads.");
    }
}