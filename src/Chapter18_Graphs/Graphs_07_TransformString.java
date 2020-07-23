package Chapter18_Graphs;

import java.util.*;

public class Graphs_07_TransformString {
    public static class StringWithDistance {
        public String candidateString;
        public Integer distance;

        public StringWithDistance(String candidateString, Integer distance) {
            this.candidateString = candidateString;
            this.distance = distance;
        }
    }

    public static int transformString(Set<String> dict, String s, String t) {
        Set<String> yetToVisit = new HashSet<>(dict);
        Queue<StringWithDistance> q = new LinkedList<>();
        yetToVisit.remove(s);
        q.add(new StringWithDistance(s, 0));

        while (!q.isEmpty()) {
            StringWithDistance f = q.poll();
            if (f.candidateString.equals(t)) {
                return f.distance;
            }

            String str = f.candidateString;
            for (int i = 0; i < str.length(); ++i) {
                String start = i == 0 ? "" : str.substring(0, i);
                String end = i + 1 > str.length() ? "" : str.substring(i + 1);
                for (int c = 0; c < 26; ++c) {
                    String modified = start + (char) ('a' + c) + end;
                    String print = String.format("%s + %c + %s = %s", start, (char) ('a' + c), end, modified);
                    System.out.println(print);
                    if (yetToVisit.contains(modified)) {
                        yetToVisit.remove(modified);
                        q.add(new StringWithDistance(modified, f.distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void test() {
        Set<String> dict = new HashSet<>(Arrays.asList("bat", "cot", "dog",
                "dag", "dot", "cat"));
        String s = "cat";
        String t = "dog";
        System.out.println("distance = " + transformString(dict, s, t));
    }
}
