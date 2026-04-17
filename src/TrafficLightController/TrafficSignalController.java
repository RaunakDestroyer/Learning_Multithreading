package TrafficLightController;

import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;

public class TrafficSignalController
{
    private final Semaphore northSem = new Semaphore(1);
    private final Semaphore eastSem  = new Semaphore(0);
    private final Semaphore southSem = new Semaphore(0);
    private final Semaphore westSem  = new Semaphore(0);

    public void dirNorth() throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            northSem.acquire();
            System.out.println("North is Green");
            eastSem.release();
        }
    }
    public void dirEast() throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            eastSem.acquire();
            System.out.println("East is Green");
            southSem.release();
        }
    }
    public void dirSouth() throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            southSem.acquire();
            System.out.println("South is Green");
            westSem.release();
        }
    }
    public void dirWest() throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            westSem.acquire();
            System.out.println("West is Green");
            northSem.release();
        }
    }
}
//____________________________________________________________________________________________________
// Using ReentrantLocks:

//    ReentrantLock lock = new ReentrantLock();
//    Condition northCondition = lock.newCondition();
//    Condition southCondition = lock.newCondition();
//    Condition eastCondition = lock.newCondition();
//    Condition westCondition = lock.newCondition();
//
//    Direction currentGreen = Direction.NORTH;
//
//    public void signal(Direction direction)
//    {
//        for(int i=0; i<3; i++)
//        {
//            try
//            {
//                lock.lock();
//                while(currentGreen!=direction)
//                {
//                    getCurrentCondition(direction).await();
//                }
//                System.out.println("" + direction + " signal is green");
//                currentGreen = getNextDirection(direction);
//                getCurrentCondition(currentGreen).signal();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//            finally
//            {
//                lock.unlock();
//            }
//        }
//    }
//    public Direction getNextDirection(Direction direction)
//    {
//        switch(direction)
//        {
//            case NORTH:
//                return Direction.EAST;
//            case SOUTH:
//                return Direction.WEST;
//            case EAST:
//                return Direction.SOUTH;
//            case WEST:
//                return Direction.NORTH;
//        }
//        return null;
//    }
//    public Condition getCurrentCondition(Direction direction)
//    {
//        switch(direction)
//        {
//            case NORTH:
//                return northCondition;
//            case SOUTH:
//                return southCondition;
//            case EAST:
//                return eastCondition;
//            case WEST:
//                return westCondition;
//        }
//        return null;
//    }
//_______________________________________________________________________________________________________________

//    public void dirNorth()
//    {
//        for(int i=0;i<3;i++)
//        {
//            try
//            {
//                lock.lock();
//                while(currentGreen!=Direction.NORTH)
//                {
//                    northCondition.await();
//                }
//                System.out.println("North is Green: East, South, West are Red " + Thread.currentThread().getName());
//                currentGreen = Direction.EAST;
//                eastCondition.signal();
//            }
//            catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }
//            finally
//            {
//                lock.unlock();
//            }
//        }
//    }
//    public void dirEast()
//    {
//        for(int i=0;i<3;i++)
//        {
//            try
//            {
//                lock.lock();
//                while(currentGreen!=Direction.EAST)
//                {
//                    eastCondition.await();
//                }
//                System.out.println("East is Green: South, West, North are Red " + Thread.currentThread().getName());
//                currentGreen = Direction.SOUTH;
//                southCondition.signal();
//            }
//            catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }
//            finally
//            {
//                lock.unlock();
//            }
//        }
//    }
//    public void dirSouth()
//    {
//        for(int i=0;i<3;i++)
//        {
//            try
//            {
//                lock.lock();
//                while(currentGreen!=Direction.SOUTH)
//                {
//                    southCondition.await();
//                }
//                System.out.println("South is Green: East, West , North are Red " + Thread.currentThread().getName());
//                currentGreen = Direction.WEST;
//                westCondition.signal();
//            }
//            catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }
//            finally
//            {
//                lock.unlock();
//            }
//        }
//    }
//    public void dirWest()
//    {
//        for(int i=0;i<3;i++)
//        {
//            try
//            {
//                lock.lock();
//                while(currentGreen!=Direction.WEST)
//                {
//                    westCondition.await();
//                }
//                System.out.println("West is Green: East, South, North are Red " + Thread.currentThread().getName());
//                currentGreen = Direction.NORTH;
//                northCondition.signal();
//            }
//            catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }
//            finally
//            {
//                lock.unlock();
//            }
//        }
//    }
