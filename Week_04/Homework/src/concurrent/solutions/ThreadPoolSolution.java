package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:36
 **/

public class ThreadPoolSolution implements Runnable {
    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(Fibo::get);
        try {
            System.out.println("Main get result = " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
