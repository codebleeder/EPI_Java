package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_13_OnlineRandomSample {
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k) {
        List<Integer> result = new ArrayList<>();
        // store first k:
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            result.add(sequence.next());
        }

        int numSeenSoFar = k;
        Random random = new Random();
        while (sequence.hasNext()) {
            numSeenSoFar++;
            int indexToReplace = random.nextInt(numSeenSoFar);
            if (indexToReplace < k) {
                result.set(indexToReplace, sequence.next());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> streamList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            streamList.add(random.nextInt(100));
        }
        List<Integer> sample = onlineRandomSample(streamList.iterator(), 4);
        System.out.println("input stream: ");
        Util.printCollection(streamList);
        System.out.println("output: ");
        Util.printCollection(sample);
    }
}
