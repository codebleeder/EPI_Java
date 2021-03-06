package Chapter14_BinarySearchTrees;

import java.util.*;

public class BinarySearchTrees_06_FindMinDistanceSortedArrays {
    public static int findMinDistanceSortedArrays(List<List<Integer>> sortedArrays){
        List<Integer> heads = new ArrayList<>(sortedArrays.size()); // contains indices
        for (List<Integer> arr : sortedArrays){
            heads.add(0);
        }
        int result = Integer.MAX_VALUE;
        NavigableSet<ArrayData> currentHeads = new TreeSet<>();

        for (int i = 0; i < sortedArrays.size(); i++){
            currentHeads.add(new ArrayData(i, sortedArrays.get(i).get(heads.get(i))));
        }
        while (true){
            result = Math.min(result,
                    currentHeads.last().val - currentHeads.first().val);
            int idxNextMin = currentHeads.first().idx;
            heads.set(idxNextMin, heads.get(idxNextMin) + 1);
            if (heads.get(idxNextMin) >= sortedArrays.get(idxNextMin).size()){
                return result;
            }
            currentHeads.pollFirst();
            currentHeads.add(new ArrayData(
                    idxNextMin, sortedArrays.get(idxNextMin).get(heads.get(idxNextMin))
            ));
        }
    }

    public static class ArrayData implements Comparable<ArrayData> {
        public int val;
        public int idx;

        public ArrayData(int idx, int val){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(ArrayData o) {
            int result = Integer.compare(val, o.val);
            if (result == 0){
                result = Integer.compare(idx, o.idx);
            }
            return result;
        }

        @Override
        public boolean equals(Object o){
            if (o == null || !(o instanceof ArrayData))
            {
                return false;
            }
            if (this == o){
                return true;
            }
            ArrayData oArrayData = (ArrayData) o;
            return this.val == oArrayData.val && this.idx == oArrayData.val;
        }
    }
    public static void test(){
        List<List<Integer>> sortedLists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5, 10, 15));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 6, 9, 12, 15));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(8, 16, 24));
        sortedLists.add(l1);
        sortedLists.add(l2);
        sortedLists.add(l3);
        int res = findMinDistanceSortedArrays(sortedLists);
        System.out.println("min distance: " + res);
    }
}
