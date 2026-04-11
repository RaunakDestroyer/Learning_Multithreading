package RaceCondition;

public class Printer implements Runnable
{
    private SharedCounter sharedCounter;

    public Printer(SharedCounter sharedCounter)
    {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run()
    {
        for(int i=1;i<=200000;i++)
        {
            synchronized (sharedCounter)
            {
                sharedCounter.counter++;
            }
        }
    }
}
