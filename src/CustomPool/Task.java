package CustomPool;

public class Task implements Runnable
{
    private int id;
    public Task(int id)
    {
        this.id = id;
    }
    @Override
    public void run()
    {
        System.out.println("Task " + id + " is executed by " + Thread.currentThread().getName());
    }
}