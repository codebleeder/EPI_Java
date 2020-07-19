package Chapter17_GreedyAlgorithms_and_Invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Greedy_01_OptimumTaskAssignment {
    public static class PairedTask {
        public Integer task1;
        public Integer task2;

        public PairedTask(Integer task1, Integer task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        @Override
        public java.lang.String toString() {
            return String.format("task1 = %d  task2 = %d", this.task1, this.task2);
        }
    }

    public static List<PairedTask> optimumTaskAssignment(List<Integer> tasks) {
        Collections.sort(tasks);
        List<PairedTask> result = new ArrayList<>();
        for (int i = 0, j = tasks.size() - 1; i < j; ++i, --j) {
            result.add(new PairedTask(tasks.get(i), tasks.get(j)));
        }
        return result;
    }

    public static void test() {
        var tasks = new ArrayList<>(Arrays.asList(5, 2, 1, 6, 4, 4));
        System.out.println("tasks: ");
        Util.Util.printCollection(tasks);
        var result = optimumTaskAssignment(tasks);
        for (PairedTask pt : result) {
            System.out.println(pt.toString());
        }
    }
}
