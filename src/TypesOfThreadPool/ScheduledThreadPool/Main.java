package TypesOfThreadPool.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Simple schedule - run once after a 5-second delay
        executor.schedule(() -> {
            System.out.println("Task executed after 5 seconds");
        }, 5, TimeUnit.SECONDS);

        // Schedule at Fixed Rate (5-second period, task takes 3 seconds)
        executor.scheduleAtFixedRate(() -> {
            long startTime = System.currentTimeMillis();
            System.out.println("RATE: Starting at " + (startTime%100000) + "ms. Task takes 3s.");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Rate: Finished at " + (endTime%100000) + "ms. (Duration: 3s)");
        }, 0, 5, TimeUnit.SECONDS);


        // Schedule with Fixed Delay (5-second delay after task completion)
        executor.scheduleWithFixedDelay(() -> {
            long startTime = System.currentTimeMillis();
            System.out.println("RATE: Starting at " + (startTime%100000) + "ms. Task takes 3s.");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Rate: Finished at " + (endTime%100000) + "ms. (Duration: 3s)");
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(5000);
        executor.shutdown();
    }
}