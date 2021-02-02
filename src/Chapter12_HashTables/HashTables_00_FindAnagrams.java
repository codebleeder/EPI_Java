package Chapter12_HashTables;

import java.util.*;

public class HashTables_00_FindAnagrams {
    private static List<List<String>> findAnagrams(List<String> dictionary) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : dictionary) {
            char[] sortedChars = word.toCharArray();
            Arrays.sort(sortedChars);
            String sortedString = new String(sortedChars);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(word);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList("debitcard",
                "elvis",
                "silent",
                "badcredit",
                "lives",
                "freedom",
                "listen",
                "levis",
                "money"
        ));
        List<List<String>> res = findAnagrams(dictionary);
        System.out.println(res);
    }
}
