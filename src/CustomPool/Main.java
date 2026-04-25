package CustomPool;

public class Main
{
    public static void  main(String[] args)
    {
        MyThreadPool threadPool = new MyThreadPool(3);
        for(int i=0; i<10; i++)
        {
            threadPool.submit(new Task(i));
        }
    }
}
