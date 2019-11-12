package Chapter13_Sorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Sorting_06_AddInterval {

    private static class Interval {
        public int left, right;
        public Interval(int left, int right){
            this.left = left;
            this.right = right;
        }
        public String toString(){
            return String.format("[%d, %d]", left, right);
        }
    }
    public static List<Interval> addInterval(List<Interval> disjointIntervals, Interval newInterval){
        List<Interval> res = new ArrayList<>();
        int i = 0;
        // add all previous intervals
        while (i < disjointIntervals.size() && disjointIntervals.get(i).right < newInterval.left){
            res.add(disjointIntervals.get(i));
            i++;
        }
        Interval combined = newInterval;
        // combine intersecting intervals
        while (i < disjointIntervals.size() &&
                (intersects(disjointIntervals.get(i), combined))){
            combined.left = Math.min(combined.left, disjointIntervals.get(i).left);
            combined.right = Math.max(combined.right, disjointIntervals.get(i).right);
            i++;
        }
        res.add(combined);
        // add all subsequent intervals

        if (i < disjointIntervals.size()){
            res.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
        }

        return res;
    }
    private static boolean intersects(Interval a, Interval b){
        return (a.left > b.left && a.left < b.right) || (a.right > b.left && a.right < b.right);
    }

    public static void test(){
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(-4, -1),
                new Interval(0,2),
                new Interval(3, 6),
                new Interval(7, 9),
                new Interval(11, 12),
                new Interval(14, 17)
        ));
        Interval newInterval = new Interval(1, 8);
        List<Interval> res = addInterval(intervals, newInterval);
        for (Interval i : res){
            System.out.println(i.toString());
        }
    }
}
