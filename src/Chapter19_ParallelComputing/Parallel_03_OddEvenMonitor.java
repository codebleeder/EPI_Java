package Chapter19_ParallelComputing;

import java.util.concurrent.locks.ReentrantLock;

public class Parallel_03_OddEvenMonitor {
    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter();
        Thread oddPrinter = new OddPrinter(oddEvenPrinter);
        Thread evenPrinter = new EvenPrinter(oddEvenPrinter);
        oddPrinter.start();
        evenPrinter.start();

        try {
            oddPrinter.join();
            evenPrinter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class OddEvenPrinter {
        private int n = 0;
        private ReentrantLock lock = new ReentrantLock();

        public int getN() {
            lock.lock();
            try {
                return n;
            } finally {
                lock.unlock();
            }
        }

        public synchronized void printEven() {
            //if(n > 100) return;
            while (n % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (n % 2 == 0) {
                System.out.println(n);
                ++n;
                notify();
            }
        }

        public synchronized void printOdd() {
            //if(n > 100) return;
            while (n % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (n % 2 != 0) {
                System.out.println(n);
                ++n;
                notify();
            }
        }
    }

    private static class OddPrinter extends Thread {
        OddEvenPrinter oddEvenPrinter;

        public OddPrinter(OddEvenPrinter oddEvenPrinter) {
            this.oddEvenPrinter = oddEvenPrinter;
        }

        @Override
        public void run() {
            while (true) {
                if (oddEvenPrinter.getN() >= 100) break;
                oddEvenPrinter.printOdd();
            }
        }
    }

    private static class EvenPrinter extends Thread {
        OddEvenPrinter oddEvenPrinter;

        public EvenPrinter(OddEvenPrinter oddEvenPrinter) {
            this.oddEvenPrinter = oddEvenPrinter;
        }

        @Override
        public void run() {
            while (true) {
                if (oddEvenPrinter.getN() >= 100) break;
                oddEvenPrinter.printEven();
            }
        }
    }
}
