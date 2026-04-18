package FooBarAlteration;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        Semaphore fooSemaphore = new Semaphore(1);
        Semaphore barSemaphore = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            for(int i=0;i<7;i++)
            {
                try
                {
                    fooSemaphore.acquire();
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Foo printed by " + Thread.currentThread().getName());
                barSemaphore.release();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<7;i++)
            {
                try
                {
                    barSemaphore.acquire();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Bar printed by " + Thread.currentThread().getName());
                fooSemaphore.release();
            }
        });
        t1.start();
        t2.start();
    }
}
