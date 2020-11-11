package concurrent.solutions;

import concurrent.Fibo;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 22:33
 **/

public class JoinSolution implements Runnable {

    private static int result;

    @Override
    public void run() {
        Thread thread = new Thread(() -> result = Fibo.get());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main get result = " + result);
    }
}
