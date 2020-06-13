package Chapter16_DynamicProgramming;

import java.util.*;

public class DP_07_DecomposeIntoDictionaryWords {

    public static List<String> decomposeIntoDictionaryWords(String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);

        for (int i = 0; i < domain.length(); ++i) {
            if (dictionary.contains(domain.substring(0, i + 1))) {
                lastLength[i] = i + 1;
            }

            if (lastLength[i] == -1) {
                for (int j = 0; j < i; ++j) {
                    if (lastLength[j] != -1 && dictionary.contains(domain.substring(j + 1, i + 1))) {
                        lastLength[i] = i - j;
                        break;
                    }
                }
            }
        }
        List<String> decompositions = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
            int idx = domain.length() - 1;
            while (idx >= 0) {
                decompositions.add(domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }

    public static void test() {
        var dictionary = new HashSet<String>(Arrays.asList(
                "a", "am", "an", "man",
                "plan", "can", "canal"));
        var res = decomposeIntoDictionaryWords("amanaplanacanal", dictionary);
        for (var sub : res) {
            System.out.println(sub);
        }

        System.out.println("-------case2-----------");
        var dictionary2 = new HashSet<>(Arrays.asList("i", "a", "am", "ace"));
        var res2 = decomposeIntoDictionaryWords("iamace", dictionary2);
        for (var sub : res2) {
            System.out.println(sub);
        }
    }

}
