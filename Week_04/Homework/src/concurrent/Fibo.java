package concurrent;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:11
 **/

public class Fibo {
    private static final int n = 32;

    public static int get() {
        if (n < 0) {
            System.out.println("Thread get result = " + 0);
            return 0;
        }
        if (n < 2) {
            System.out.println("Thread get result = " + 1);
            return 1;
        }
        int i = 1, j = 1;
        int result = 2;
        for (int index = 2; index <= n; ++index) {
            result = i + j;
            i = j;
            j = result;
        }
        System.out.println("Thread get result = " + result);
        return result;
    }


}
