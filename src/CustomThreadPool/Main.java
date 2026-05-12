package CustomThreadPool;

public class Main
{
    public static void  main(String[] args) throws InterruptedException
    {
        MyThreadPool threadPool = new MyThreadPool(3);
        for(int i=0; i<10; i++)
        {
            threadPool.submit(new Task(i));
        }
        Thread.sleep(1000);

        threadPool.shutdown();
        System.out.println("Thread pool shut down.");
    }
}
