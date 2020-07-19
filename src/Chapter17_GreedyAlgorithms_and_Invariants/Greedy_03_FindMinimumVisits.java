package Chapter17_GreedyAlgorithms_and_Invariants;

import Util.Util;

import java.util.*;

public class Greedy_03_FindMinimumVisits {
    public static class Interval implements Comparable<Interval> {
        public Integer start;
        public Integer end;

        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.end, o.end);
        }
    }

    public static List<Integer> findMinimumVisits(List<Interval> intervals) {
        Collections.sort(intervals);
        List<Integer> visits = new ArrayList<>();
        visits.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start > visits.get(visits.size() - 1)) {
                visits.add(intervals.get(i).end);
            }
        }
        return visits;
    }

    public static void test() {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(0, 3),
                new Interval(2, 6),
                new Interval(3, 4),
                new Interval(6, 9)
        ));
        List<Integer> res = findMinimumVisits(intervals);
        Util.printCollection(res);

        List<Interval> intervals2 = new ArrayList<>(Arrays.asList(
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(4, 5)
        ));
        List<Integer> res2 = findMinimumVisits(intervals2);
        Util.printCollection(res2);
    }
}
