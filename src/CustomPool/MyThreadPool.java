package CustomPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool
{
    private final int poolSize;
    private final Worker[] workers;
    private BlockingQueue<Task> taskQueue;

    public MyThreadPool(int poolSize)
    {
        this.poolSize = poolSize;
        this.workers = new Worker[poolSize];
        this.taskQueue = new LinkedBlockingQueue<>();

        for(int i=0; i<poolSize; i++)
        {
            workers[i] = new Worker("Worker-" + i, taskQueue);
            workers[i].start();
        }
    }
    public void submit(Task task)
    {
        taskQueue.offer(task);
    }
}