package Chapter13_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_07_UnionOfIntervals {
    public static List<Sorting_07_Interval> unionOfIntervals (List<Sorting_07_Interval> intervals) {
        Collections.sort(intervals);
        List<Sorting_07_Interval> res = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++){
            Sorting_07_Interval prev = intervals.get(i-1);
            Sorting_07_Interval curr = intervals.get(i);
            if (isDisjoint(prev, curr)){
                res.add(prev);
            }
            else {
                intervals.set(i, combine(prev, curr));
            }
        }
        res.add(intervals.get(intervals.size()-1));
        return res;
    }
    public static boolean isDisjoint(Sorting_07_Interval a, Sorting_07_Interval b){
        if (a.right.val == b.left.val && (a.right.isClosed || b.left.isClosed)) { return false;}
        if (a.right.compareTo(b.left) < 0) { return true; }
        if (a.right.compareTo(b.left) == 0) {
            if (a.right.isClosed){
                return false;
            }
            return true;
        }
        return false;
    }
    public static Sorting_07_Interval combine (Sorting_07_Interval a, Sorting_07_Interval b){
        Sorting_07_Interval combined = new Sorting_07_Interval();
        combined.left = a.left;
        if (a.right.val == b.right.val){
            combined.right.val = b.right.val;
            combined.right.isClosed = a.right.isClosed || b.right.isClosed;
        }
        else if (a.right.val > b.right.val){
            combined.right = a.right;
        }
        else {
            combined.right = b.right;
        }
        /*
        if (a.right.compareTo(b.right) < 0 || a.right.compareTo(b.right) == 0){
            combined.right.val = b.right.val;
            combined.right.isClosed = a.right.isClosed || b.right.isClosed;
        }
        else {
            combined.right = a.right;
        }
        */
        return combined;
    }
    public static void test(){
        List<Sorting_07_Interval> intervals = new ArrayList<>(Arrays.asList(
                new Sorting_07_Interval(new Sorting_07_Endpoint(0, false), new Sorting_07_Endpoint(3, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(1, true), new Sorting_07_Endpoint(1, true)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(2, true), new Sorting_07_Endpoint(4, true)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(3, true), new Sorting_07_Endpoint(4, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(5, true), new Sorting_07_Endpoint(7, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(7, true), new Sorting_07_Endpoint(8, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(8, true), new Sorting_07_Endpoint(11, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(9, false), new Sorting_07_Endpoint(11, true)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(12, true), new Sorting_07_Endpoint(14, true)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(12, false), new Sorting_07_Endpoint(16, true)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(13,false), new Sorting_07_Endpoint(15, false)),
                new Sorting_07_Interval(new Sorting_07_Endpoint(16, false), new Sorting_07_Endpoint(17, false))
        ));
        List<Sorting_07_Interval> res = unionOfIntervals(intervals);
        for(Sorting_07_Interval i : res){
            System.out.println(i.toString());
        }
    }
}
