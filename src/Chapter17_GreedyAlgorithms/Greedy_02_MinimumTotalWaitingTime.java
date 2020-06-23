package Chapter17_GreedyAlgorithms;

import Util.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Greedy_02_MinimumTotalWaitingTime {
    public static Integer minimumTotalWaitingTime(List<Integer> serviceTimes) {
        Collections.sort(serviceTimes);
        int totalWaitingTime = 0;
        for (int i = 0; i < serviceTimes.size(); ++i) {
            Integer remainingQueries = serviceTimes.size() - (i + 1);
            totalWaitingTime += serviceTimes.get(i) * remainingQueries;
        }
        return totalWaitingTime;
    }

    public static void test() {
        List<Integer> serviceTimes1 = new ArrayList<>(Arrays.asList(2, 5, 1, 3));
        TestCase<List<Integer>, Integer> case1 = new TestCase<>(serviceTimes1, 10);

        List<TestCase> tests = new ArrayList<>();
        tests.add(case1);

        tests.add(new TestCase<List<Integer>, Integer>(
                new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                4));
        for (TestCase<List<Integer>, Integer> tCase : tests) {
            String res = String.format("result = %d  expected = %d",
                    minimumTotalWaitingTime(tCase.input), tCase.expected);
            System.out.println(res);
        }
    }
}
