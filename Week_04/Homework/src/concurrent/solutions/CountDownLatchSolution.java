package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.CountDownLatch;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:55
 **/

public class CountDownLatchSolution implements Runnable {
    private static int result = 0;

    @Override
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                result = Fibo.get();
            } finally {
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main get result = " + result);
    }
}
