package Chapter17_GreedyAlgorithms_and_Invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invariants_06_FindAmpleCity {
    public static class CityAndRemainingGas {
        public Integer city;
        public Integer remainingGallons;

        public CityAndRemainingGas(Integer city, Integer remainingGallons) {
            this.city = city;
            this.remainingGallons = remainingGallons;
        }

        @Override
        public String toString() {
            return String.format("city = %d  remainingGallons = %d", city, remainingGallons);
        }
    }

    public static final int MPG = 20;

    public static CityAndRemainingGas findAmpleCity(List<Integer> gallons, List<Integer> distances) {
        CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
        int remainingGas = 0;
        for (int i = 1; i < gallons.size(); ++i) {
            int gasConsumed = distances.get(i - 1) / MPG;
            remainingGas += gallons.get(i - 1) - gasConsumed;

            if (remainingGas < min.remainingGallons) {
                min = new CityAndRemainingGas(i, remainingGas);
            }
        }
        return min;
    }

    public static void test() {
        List<Integer> gallons = new ArrayList<>(Arrays.asList(50, 20, 5, 30, 25, 10, 10));
        List<Integer> distances = new ArrayList<>(Arrays.asList(900, 600, 200, 400, 600, 200, 100));
        CityAndRemainingGas result = findAmpleCity(gallons, distances);
        String display = String.format("expected city = %d, result = %s", 3, result);
        System.out.println(display);
    }
}
