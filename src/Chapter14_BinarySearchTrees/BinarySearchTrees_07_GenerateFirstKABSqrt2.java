package Chapter14_BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class BinarySearchTrees_07_GenerateFirstKABSqrt2 {

    public static class ABSqrt2 implements Comparable<ABSqrt2> {
        public int a, b;
        public double val;
        public ABSqrt2(int a, int b){
            this.a = a;
            this.b = b;
            this.val = a + b * Math.sqrt(2);
        }

        @Override
        public int compareTo(ABSqrt2 o) {
            return Double.compare(val, o.val);
        }

        @Override
        public String toString(){
            return this.a + " + " + this.b + " root(2) = " + this.val;
        }
    }

    public static List<ABSqrt2> generateFirstKABSqrt2(int k){
        SortedSet<ABSqrt2> candidates = new TreeSet<>();
        candidates.add(new ABSqrt2(0, 0));
        List<ABSqrt2> result = new ArrayList<>();
        while (result.size() < k){
            // extract smallest
            ABSqrt2 nextSmallest = candidates.first();
            result.add(nextSmallest);
            candidates.add(new ABSqrt2(nextSmallest.a + 1, nextSmallest.b));
            candidates.add(new ABSqrt2(nextSmallest.a, nextSmallest.b + 1));
            candidates.remove(nextSmallest);
        }
        return result;
    }

    public static List<ABSqrt2> generateFirstKABSqrt2_2(int k){
        List<ABSqrt2> result = new ArrayList<>();
        result.add(new ABSqrt2(0, 0));
        int i = 0, j = 0;
        for (int n = 1; n < k; n++){
            ABSqrt2 resultIPlus1 = new ABSqrt2(result.get(i).a + 1, result.get(i).b);
            ABSqrt2 resultJPlusSqrt2 = new ABSqrt2(result.get(j).a, result.get(j).b + 1);
            result.add(resultIPlus1.val < resultJPlusSqrt2.val ? resultIPlus1 : resultJPlusSqrt2);
            if (resultIPlus1.compareTo(result.get(result.size()-1)) == 0){
                ++i;
            }
            if (resultJPlusSqrt2.compareTo(result.get(result.size()-1)) == 0){
                ++j;
            }
        }
        return result;
    }

    public static void test(){
        List<ABSqrt2> result = generateFirstKABSqrt2(5);
        for (ABSqrt2 res : result){
            System.out.println(res.toString());
        }
        System.out.println();
        List<ABSqrt2> result2 = generateFirstKABSqrt2_2(5);
        for (ABSqrt2 res : result2){
            System.out.println(res.toString());
        }
    }



}



