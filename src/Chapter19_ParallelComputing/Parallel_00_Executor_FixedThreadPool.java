package Chapter19_ParallelComputing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallel_00_Executor_FixedThreadPool {
    public static void main(String[] args) {
        final int N = 5;
        ExecutorService es = Executors.newFixedThreadPool(N);
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            Task t = new Task(i);
            tasks.add(t);
        }
        // es.invoke() will execute and join
        // es.submit(), es.execute() will add the tasks to work queue to be run later on.
        // es.execute() does not return anything; es.submit() returns a Future object
        for (int i = 0; i < N; ++i) {
            es.execute(tasks.get(i));
        }

    }

    public static class Task implements Runnable {
        int id;

        public Task(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("running task " + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
