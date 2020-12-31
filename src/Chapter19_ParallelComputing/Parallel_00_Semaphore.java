package Chapter19_ParallelComputing;

public class Parallel_00_Semaphore {
    public static class Semaphore {
        private final int MAX_AVAILABLE;
        private int taken = 0;

        public Semaphore(int max_available) {
            MAX_AVAILABLE = max_available;
        }

        public synchronized void acquire() throws InterruptedException {
            while (this.taken == MAX_AVAILABLE) {
                wait();
            }
            this.taken++;
        }

        public synchronized void release() throws InterruptedException {
            this.taken--;
            this.notifyAll();
        }
    }
}
