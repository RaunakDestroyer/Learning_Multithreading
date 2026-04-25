package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    private final ReentrantLock lock = new ReentrantLock();
    private int value = 0;

    public void outerMethod() {
        lock.lock(); // hold count: 1
        try
        {
            System.out.println("Outer: hold count = " + lock.getHoldCount()); // 1
            innerMethod(); // same thread re-enters
            System.out.println("Outer after inner: hold count = " + lock.getHoldCount()); // back to 1
        }
        finally
        {
            lock.unlock(); // hold count: 0 → lock released
        }
    }
    public void innerMethod()
    {
        lock.lock(); // same thread — hold count becomes 2 instead of blocking
        try
        {
            System.out.println("Inner: hold count = " + lock.getHoldCount()); // 2
            value++;
        }
        finally
        {
            lock.unlock(); // hold count: 1 (not fully released yet!)
        }
    }
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.outerMethod();
        System.out.println("Lock held after all: " + demo.lock.isLocked()); // false
    }
}
