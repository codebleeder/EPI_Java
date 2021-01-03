package Chapter19_ParallelComputing;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Parallel_09_Collatz {
    private static boolean collatzCheck(BigInteger aNum, Set<BigInteger> visited) {
        if (aNum.equals(BigInteger.ONE)) {
            return true;
        } else if (visited.contains(aNum)) {
            return false;
        }
        visited.add(aNum);
        if (aNum.getLowestSetBit() == 1) {
            return collatzCheck(new BigInteger("3").multiply(aNum).add(BigInteger.ONE), visited);
        } else {
            return collatzCheck(aNum.shiftRight(1), visited);
        }
    }

    private static boolean collatzCheck(Integer aNum, Set<BigInteger> visited) {
        BigInteger b = new BigInteger(aNum.toString());
        return collatzCheck(b, visited);
    }

    private static class Task implements Runnable {
        public int lower;
        public int upper;

        public Task(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        @Override
        public void run() {
            for (int i = lower; i <= upper; ++i) {
                collatzCheck(i, new HashSet<BigInteger>());
            }
        }
    }

    //static int N = 10000000;
    static int N = 15897546;
    static int RANGESIZE = 1000000;
    static int NTHREADS = 8;

    private static ExecutorService execute() {
        ExecutorService es = Executors.newFixedThreadPool(8);
        for (int i = 0; i < (N / RANGESIZE); ++i) {
            Task task = new Task(i * RANGESIZE + 1, (i + 1) * RANGESIZE);
            es.execute(task);
        }
        es.shutdown();
        return es;
    }

    public static void main(String[] args) {

        long lDateTime = new Date().getTime();

        ExecutorService executor = execute();
        try {
            while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Finished all threads");
        long fDateTime = new Date().getTime();
        System.out.println("time in milliseconds for checking to " + N + " is "
                + (fDateTime - lDateTime) + " ("
                + N / (fDateTime - lDateTime) + " per ms)");
    }
}
