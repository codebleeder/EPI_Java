package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_07_MinMax {
    public static class MinMax {
        public int min;
        public int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        private static MinMax getMinMax(int a, int b) {
            return a > b ? new MinMax(b, a) : new MinMax(a, b);
        }

        public String toString() {
            return String.format("min: %d, max: %d", min, max);
        }
    }

    public static MinMax findMinMax(List<Integer> arr) {
        if (arr.size() <= 1) {
            return new MinMax(arr.get(0), arr.get(0));
        }

        MinMax globalMinMax = MinMax.getMinMax(arr.get(0), arr.get(1));

        for (int i = 2; i < arr.size() - 1; i += 2) {
            MinMax localMinMax = MinMax.getMinMax(arr.get(i), arr.get(i + 1));
            globalMinMax = new MinMax(Math.min(localMinMax.min, globalMinMax.min),
                    Math.max(localMinMax.max, globalMinMax.max));
        }

        if ((arr.size() % 2) != 0) {
            int last = arr.get(arr.size() - 1);
            globalMinMax = new MinMax(Math.min(last, globalMinMax.min),
                    Math.max(last, globalMinMax.max));
        }

        return globalMinMax;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 2, 5, 1, 2, 4));
        MinMax res = findMinMax(arr);
        System.out.println(res.toString());
    }
}
