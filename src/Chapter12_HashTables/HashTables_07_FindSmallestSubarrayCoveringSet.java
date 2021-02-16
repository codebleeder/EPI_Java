package Chapter12_HashTables;

import java.util.*;

public class HashTables_07_FindSmallestSubarrayCoveringSet {
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

    private static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph, Set<String> keywords) {
        Subarray res = new Subarray(-1, -1);
        int left = 0, right = 0;
        Set<String> iterKeywords = new HashSet<>(keywords);
        while (right < paragraph.size()) {
            // move right until all keywords are covered
            while (right < paragraph.size() && iterKeywords.size() > 0) {
                String word = paragraph.get(right);
                if (keywords.contains(word)) {
                    iterKeywords.remove(word);
                    if (iterKeywords.size() == 0) {
                        break;
                    }
                }
                ++right;
            }
            // all terms are covered; update res
            if ((res.start == -1 && res.end == -1) ||
                    res.getLength() > (right - left)) {
                res.start = left;
                res.end = right;
            }

            // move left until one of the keywords is hit
            while (left < paragraph.size() && !keywords.contains(paragraph.get(left))) {
                ++left;
            }
            if ((res.start == -1 && res.end == -1) ||
                    res.getLength() > (right - left)) {
                res.start = left;
                res.end = right;
            }

            ++left;
            iterKeywords.add(paragraph.get(left - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        String paragraph = "apple,banana,apple,apple,dog,cat,apple,dog,banana,apple,cat,dog";
        List<String> paragraphList = new ArrayList<>(Arrays.asList(paragraph.split(",")));
        Set<String> keywords = new HashSet<>(Arrays.asList("banana", "cat"));
        System.out.println(paragraphList);
        Subarray res = findSmallestSubarrayCoveringSet(paragraphList, keywords);
        System.out.println(res.toString());
    }
}
