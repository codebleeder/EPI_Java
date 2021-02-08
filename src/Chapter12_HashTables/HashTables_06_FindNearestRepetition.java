package Chapter12_HashTables;

import java.util.*;

public class HashTables_06_FindNearestRepetition {
    public static int findNearestRepetition(List<String> paragraph) {
        Map<String, Integer> map = new HashMap<>();
        int nearestRepeatedDistance = Integer.MAX_VALUE;
        for (int i = 0; i < paragraph.size(); ++i) {
            String word = paragraph.get(i);
            if (map.containsKey(word)) {
                nearestRepeatedDistance = Math.min(nearestRepeatedDistance, i - map.get(word));
            }
            map.put(word, i);
        }
        return nearestRepeatedDistance;
    }

    public static void main(String[] args) {
        String line = "all work and no play makes for no work no fun and no results";
        List<String> paragraph = new ArrayList<>(Arrays.asList(line.split(" ")));
        System.out.println(paragraph);
        System.out.println("nearest repetition: " + findNearestRepetition(paragraph));
    }
}
