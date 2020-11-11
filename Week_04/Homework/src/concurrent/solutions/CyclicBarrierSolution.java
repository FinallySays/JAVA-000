package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 21:02
 **/

public class CyclicBarrierSolution implements Runnable{
    private static int result = 0;

    @Override
    public void run() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            result = Fibo.get();
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main get result = " + result);
    }
}
