package Chapter17_GreedyAlgorithms_and_Invariants;

import java.util.*;

public class Invariants_08_CalculateLargestRectangle {
    public static int calculateLargestRectangle(List<Integer> heights) {
        Deque<Integer> pillarIndices = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.size(); ++i) {
            while (!pillarIndices.isEmpty()
                    && isNewPillarOrReachEnd(heights, i, pillarIndices.peekFirst())) {
                int height = heights.get(pillarIndices.removeFirst());
                int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peekFirst() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            pillarIndices.addFirst(i);
        }
        return maxArea;
    }

    private static boolean isNewPillarOrReachEnd(List<Integer> heights,
                                                 int i, Integer lastPillarIndex) {
        return i < heights.size()
                ? heights.get(i) <= heights.get(lastPillarIndex)
                : true;
    }

    public static void test() {
        List<Integer> heights = new ArrayList<>(Arrays.asList(
                1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3
        ));
        System.out.println("expected = 20  result = " + calculateLargestRectangle(heights));
    }
}
