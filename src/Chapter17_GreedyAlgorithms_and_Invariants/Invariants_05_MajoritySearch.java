package Chapter17_GreedyAlgorithms_and_Invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Invariants_05_MajoritySearch {
    public static String majoritySearch(Iterator<String> inputStream) {
        String candidate = "";
        int candidateCount = 0;
        while (inputStream.hasNext()) {
            String next = inputStream.next();
            if (candidateCount == 0) {
                candidate = next;
                candidateCount = 1;
            } else if (candidate.equals(next)) {
                ++candidateCount;
            } else {
                --candidateCount;
            }
        }
        return candidate;
    }

    public static void test() {
        List<String> stream = new ArrayList<>(Arrays.asList("b", "a", "c", "a", "a", "b",
                "a", "a", "c", "a"));
        String display = String.format("result = %s  expected = a", majoritySearch(stream.iterator()));
        System.out.println(display);
    }
}