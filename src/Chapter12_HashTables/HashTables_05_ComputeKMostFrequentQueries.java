package Chapter12_HashTables;

import java.util.*;

public class HashTables_05_ComputeKMostFrequentQueries {
    static class WordFrequency implements Comparable<WordFrequency> {
        public String word;
        public Integer frequency;

        public WordFrequency(String word, Integer frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFrequency o) {
            return o.frequency.compareTo(this.frequency);
        }

        @Override
        public String toString() {
            return String.format("[word:%s, freq:%d]", word, frequency);
        }
    }

    public static List<WordFrequency> computeKMostFrequentQueries(List<String> queries, int k) {
        Map<String, Integer> wordToFreq = new HashMap<>();
        for (String query : queries) {
            if (wordToFreq.containsKey(query)) {
                wordToFreq.put(query, wordToFreq.get(query) + 1);
            } else {
                wordToFreq.put(query, 1);
            }
        }

        List<WordFrequency> wordFrequencies = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
            wordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
        }

        Collections.sort(wordFrequencies);

        return wordFrequencies.subList(0, k);
    }

    public static void main(String[] args) {
        List<String> queries = new ArrayList<>();
        final int RANGE = 26;
        Random r = new Random();
        for (int i = 0; i < 100; ++i) {
            int randomVal = r.nextInt(RANGE);
            char c = (char) (97 + randomVal);
            queries.add(String.valueOf(c));
        }
        List<WordFrequency> res = computeKMostFrequentQueries(queries, 5);
        System.out.println(res);
    }
}
