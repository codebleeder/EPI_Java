package Chapter12_HashTables;

import java.util.HashSet;
import java.util.Set;

public class HashTables_13_TestCollatzConjecture {
    public static boolean testCollatzConjecture(int n) {
        Set<Long> verifiedNumbers = new HashSet<>();
        for (int i = 3; i <= n; i += 2) {
            Set<Long> sequence = new HashSet<>();
            long testI = i;
            while (testI >= i) {
                if (!sequence.add(testI)) { // you hit a loop and the hypothesis is false
                    return false;
                }
                if (testI % 2 != 0) {
                    if (!verifiedNumbers.add(testI)) {
                        break;
                    }
                    long nextTestI = testI * 3 + 1;
                    if (nextTestI <= testI) {
                        throw new ArithmeticException("overflow");
                    }
                    testI = nextTestI;
                } else {
                    testI /= 2;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(testCollatzConjecture(9876));
    }
}
