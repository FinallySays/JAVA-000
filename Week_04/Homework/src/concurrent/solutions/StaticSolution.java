package concurrent.solutions;


import concurrent.Fibo;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:22
 **/

public class StaticSolution implements Runnable{
    private static volatile int result = -1;
    public void run() {
        new Thread(() -> result = Fibo.get()).start();
        while(result == -1) {

        }
        System.out.println("Main get result = " + result);
    }

}
