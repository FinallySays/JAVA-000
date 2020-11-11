package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 21:14
 **/

public class ExecutorCompletionServiceSolution implements Runnable {
    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
        executorCompletionService.submit(Fibo::get);
        try {
            System.out.println("Main get result = " + executorCompletionService.take().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
