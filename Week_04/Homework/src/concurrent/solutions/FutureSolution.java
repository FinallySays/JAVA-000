package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 21:30
 **/

public class FutureSolution implements Runnable {
    @Override
    public void run() {
        FutureTask<Integer> futureTask = new FutureTask<>(Fibo::get);
        new Thread(futureTask).start();
        try {
            System.out.println("Main get result = " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
