package concurrent;

import org.junit.Test;
import concurrent.solutions.*;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:32
 **/

public class Application {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.add(new CountDownLatchSolution());
        proxy.add(new CyclicBarrierSolution());
        proxy.add(new ExecutorCompletionServiceSolution());
        proxy.add(new LockSolution());
        proxy.add(new FutureSolution());
        proxy.add(new JoinSolution());
        proxy.add(new CompletableFutureSolution());
        proxy.add(new ThreadPoolSolution());
        proxy.add(new StaticSolution());
        proxy.start();
    }

}
