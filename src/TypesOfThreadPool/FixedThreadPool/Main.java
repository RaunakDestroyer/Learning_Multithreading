package TypesOfThreadPool.FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Submitting 5 tasks to a 2-Thread Fixed Pool: ");
        for (int i = 1; i <= 5; i++)
        {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " finished by Thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        System.out.println("\nAll tasks submitted. Waiting for completion...");
    }
}
