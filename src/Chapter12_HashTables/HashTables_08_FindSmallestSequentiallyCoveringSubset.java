package Chapter12_HashTables;

import java.util.*;

public class HashTables_08_FindSmallestSequentiallyCoveringSubset {
    private static class Subarray {
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("[start: %d, end: %d]", start, end);
        }

        public Integer getLength() {
            return end - start;
        }
    }

    private static Subarray findSmallestSequentiallyCoveringSubset(List<String> paragraph,
                                                                   List<String> keywords) {
        Subarray res = new Subarray(-1, -1);
        int left = 0, right = 0, keywordPtr = 0;

        while (right < paragraph.size()) {
            // move right until all keywords are covered in sequence
            while (keywordPtr < keywords.size() && right < paragraph.size()) {
                if (paragraph.get(right).equals(keywords.get(keywordPtr))) {
                    ++keywordPtr;
                }
                ++right;
            }
            --keywordPtr;
            --right;
            if (right == paragraph.size() - 1 && !paragraph.get(right).equals(keywords.get(keywords.size() - 1))) {
                return res;
            }
            // move left until first word of keywords is hit
            while (left < paragraph.size() && !paragraph.get(left).equals(keywords.get(0))) {
                ++left;
            }
            Subarray currentSubarray = new Subarray(left, right);
            if ((res.start == -1 && res.end == -1)
                    || currentSubarray.getLength() < res.getLength()) {
                res = currentSubarray;
            }
            ++left;
            right = left;
            keywordPtr = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        String paragraph = "apple,banana,apple,apple,dog,cat,apple,dog,banana,apple,cat,dog";
        List<String> paragraphList = new ArrayList<>(Arrays.asList(paragraph.split(",")));
        List<String> keywords = new ArrayList<>(Arrays.asList("banana", "cat"));
        System.out.println(paragraphList);
        Subarray res = findSmallestSequentiallyCoveringSubset(paragraphList, keywords);
        System.out.println(res.toString());
    }
}
