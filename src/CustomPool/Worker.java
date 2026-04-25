package CustomPool;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread
{
    BlockingQueue<Task> taskQueue;
    public Worker(String name, BlockingQueue<Task> taskQueue)
    {
        super(name);
        this.taskQueue = taskQueue;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Runnable task = taskQueue.take();
                task.run();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
