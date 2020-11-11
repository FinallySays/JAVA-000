package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Homework
 * @description:
 * @author: Shiwp
 * @create: 2020-11-11 20:30
 **/

public class Proxy {
    private List<Runnable> list = new ArrayList<>();

    public void add(Runnable solution) {
        list.add(solution);
    }

    public void start() {
        for (Runnable solution : list) {
            System.out.println("======================");
            System.out.println("Now Test " + solution.getClass().getSimpleName());
            long startTime = System.currentTimeMillis();
            solution.run();
            long endTime = System.currentTimeMillis();
            System.out.println("Duration time : " + (endTime - startTime) + "ms");
        }
    }
}
