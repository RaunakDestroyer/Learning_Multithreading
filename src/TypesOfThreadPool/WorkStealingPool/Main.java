package TypesOfThreadPool.WorkStealingPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        System.out.println("Submitting 30 tasks to the Work-Stealing Pool " + Runtime.getRuntime().availableProcessors() + " cores: ");

        for (int i = 1; i <= 30; i++)
        {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + ": Running on Thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.awaitTermination(2, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println("\nAll taskd finished or pool shut down. ");
    }
}
