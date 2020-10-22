package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_16_NonUniformRandomNumberGeneration {
    public static int nonUniformRandomNumberGeneration(List<Integer> values,
                                                       List<Double> probabilities) {
        List<Double> prefixSumOfProbabilities = new ArrayList<>();
        /*
        prefixSumOfProbabilities.add(0.0);
        for(double p: probabilities){
            prefixSumOfProbabilities.add(
                    prefixSumOfProbabilities.get(prefixSumOfProbabilities.size()-1) + p);
        }
        */
        probabilities.stream().reduce(0.0, (left, right) -> {
            prefixSumOfProbabilities.add(left + right);
            return left + right;
        });
        Random r = new Random();
        final double uniform01 = r.nextDouble();
        int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
        if (it < 0) {
            final int intervalIndex = (Math.abs(it) - 1);
            return values.get(intervalIndex);
        } else {
            return values.get(it);
        }
    }

    public static void main(String[] args) {
        List<Double> prob = new ArrayList<>(Arrays.asList(0.5, 0.333, 0.1, 0.05));
        List<Integer> values = new ArrayList<>(Arrays.asList(3, 5, 7, 11));
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            results.add(nonUniformRandomNumberGeneration(values, prob));
        }
        Util.printCollection(results);
    }
}
