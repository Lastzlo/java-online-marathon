package task2;

import task1.ParallelCalculator;

/**Task 2
 * Suppose, you have class from task #1 ParallelCalculator that is able to execute an operation in separate thread. It uses an implementation of Runnable interface for this.
 *
 * You need to create Accountant class with a static sum(...) method that takes two parameters of type int and returns their sum. Use ParallelCalculator for this. The sum(...) method doesn't throw any checked exceptions.
 *
 * The sum must be evaluated in a separate thread  (please, do not call run() method of ParallelCalculator. Use start() method on object of type Thread).
 *
 * Using Thread.sleep() method is unwelcomed in this task.
 * */
public class Accountant {
    public static int sum(int x, int y) {
        ParallelCalculator calc = new ParallelCalculator(Integer::sum, x, y);
        Thread t = new Thread(calc);
        t.start();
        try{ t.join();} catch (InterruptedException e){}
        return calc.result;
    }

    public static int sum_Alternative(int x, int y) {
        ParallelCalculator calc =
                new ParallelCalculator(Integer::sum, x, y);
        Thread t = new Thread(calc);
        t.start();
        //бесконечно проверяет что поток жив, и лиш потом выполняет следующий шаг;
        while (t.isAlive());
        return calc.result;
    }
}
