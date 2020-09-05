package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_09_GeneratePrimes {
    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p <= n; ++p) {
            if (isPrime.get(p)) {
                primes.add(p);
                for (int i = p; i <= n; i += p) {
                    isPrime.set(i, false);
                }
            }
        }
        return primes;
    }

    // optimized:
    public static List<Integer> generatePrimes2(int n) {
        final int size = (int) Math.floor(0.5 * (n - 3)) + 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < size; ++i) {
            if (isPrime.get(i)) {
                int p = ((i * 2) + 3);
                primes.add(p);
                for (int j = ((i * i) * 2) + 6 * i + 3; j < size; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }

    // simplified:
    public static List<Integer> generatePrimes3(int n) {
        List<Integer> primes = new ArrayList<>();
        int size = (int) Math.floor(((n - 3) * 0.5)) + 1;
        primes.add(2);
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < isPrime.size(); ++i) {
            if (isPrime.get(i)) {
                int p = (2 * i) + 3;
                primes.add(p);
                // remove multiples of prime
                for (int j = i; j < size; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }

    public static void test() {
        List<Integer> result = generatePrimes2(50);
        System.out.println("result: ");
        Util.printCollection(result);
    }

    public static void main(String[] args) {
        test();
    }
}
