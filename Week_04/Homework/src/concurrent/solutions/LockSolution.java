package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 21:19
 **/

public class LockSolution implements Runnable {
    private static int result;

    @Override
    public void run() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                result = Fibo.get();
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();


        lock.lock();
        try {
            condition.await(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println("Main get result = " + result);
    }
}
