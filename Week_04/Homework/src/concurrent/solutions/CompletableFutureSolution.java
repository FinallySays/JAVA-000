package concurrent.solutions;

import concurrent.Fibo;
import java.util.concurrent.CompletableFuture;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:50
 **/

public class CompletableFutureSolution implements Runnable{

    @Override
    public void run() {
        System.out.println("Main get result = " + CompletableFuture.supplyAsync(Fibo::get).join());
    }

}
