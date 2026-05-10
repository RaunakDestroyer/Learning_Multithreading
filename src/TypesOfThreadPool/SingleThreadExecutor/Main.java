package TypesOfThreadPool.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("Submitting 3 tasks to a Single-Thread Executor: ");

        for (int i = 1; i <= 3; i++)
        {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + ": Executing...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + ": Completed.");
            });
        }
        executor.shutdown();
    }
}
