package Chapter04_PrimitiveTypes;

import java.util.Random;

public class PrimitiveTypes_10_UniformRandom {
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1;
        int result;
        Random random = new Random();
        do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
                result = (result << 1) | random.nextInt(2);
            }
        } while (result >= numberOfOutcomes);
        return result + lowerBound;
    }

    public static void test() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("uniformRandom(6) = " + uniformRandom(10, 15));
        }

    }

    public static void main(String[] args) {
        test();
    }
}
