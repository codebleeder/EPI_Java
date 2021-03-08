package Chapter12_HashTables;

import java.util.*;

public class HashTables_12_FindAllSubstrings {
    public static List<Integer> findAllSubstrings(String s, List<String> words) {
        Map<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            increment(word, wordToFreq);
        }

        int unitSize = words.get(0).length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + unitSize * words.size() <= s.length(); ++i) {
            if (matchAllWordsInDict(s, wordToFreq, i, words.size(), unitSize)) {
                result.add(i);
            }
        }
        return result;
    }

    private static void increment(String word, Map<String, Integer> dict) {
        Integer count = dict.get(word);
        if (count == null) {
            count = 0;
        }
        dict.put(word, count + 1);
    }

    private static boolean matchAllWordsInDict(String s,
                                               Map<String, Integer> wordToFreq,
                                               int start,
                                               int numWords,
                                               int unitSize) {
        Map<String, Integer> currStringToFreq = new HashMap<>();
        for (int i = 0; i < numWords; ++i) {
            String currWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            Integer freq = wordToFreq.get(currWord);
            if (freq == null) {
                return false;
            }
            increment(currWord, currStringToFreq);
            if (currStringToFreq.get(currWord) > freq) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAllSubstrings2(String s, List<String> words) {
        Map<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            increment(word, wordToFreq);
        }

        int wordSize = words.get(0).length();
        int substringSize = words.size() * wordSize;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (i < s.length() - substringSize) {
            if (substringQualifies(s, wordToFreq, substringSize, wordSize, i)) {
                res.add(i);
                i += substringSize;
            } else {
                ++i;
            }

        }
        return res;
    }

    private static boolean substringQualifies(String s,
                                              Map<String, Integer> wordToFreq,
                                              int substringSize, int wordSize, int start) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = start; i < start + substringSize - wordSize; i += wordSize) {
            String substring = s.substring(i, i + wordSize);
            Integer freq = wordToFreq.get(substring);
            if (freq == null) {
                return false;
            }
            increment(substring, map);
            if (map.get(substring) > freq) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "amanaplanacanal";
        List<String> words = new ArrayList<>(Arrays.asList("can", "apl", "ana"));
        List<Integer> res = findAllSubstrings2(s, words);
        System.out.println(res);

        s = "barfoothefoobarman";
        words = new ArrayList<>(Arrays.asList("foo", "bar"));
        res = findAllSubstrings2(s, words);
        System.out.println(res);
    }
}
