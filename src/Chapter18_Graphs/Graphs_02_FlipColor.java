package Chapter18_Graphs;

import java.util.*;

public class Graphs_02_FlipColor {
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void flipColor(List<List<Boolean>> arr, int x, int y) {
        final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        boolean color = arr.get(x).get(y);
        Queue<Coordinate> q = new LinkedList<>();
        arr.get(x).set(y, !color);
        q.add(new Coordinate(x, y));
        while (!q.isEmpty()) {
            Coordinate cur = q.element();
            for (int[] dir : dirs) {
                Coordinate next = new Coordinate(cur.x + dir[0], cur.y + dir[1]);
                if (isValid(next, color, arr)) {
                    arr.get(next.x).set(next.y, !color);
                    q.add(next);
                }
            }
            q.remove();
        }
    }

    public static boolean isValid(Coordinate curr, boolean color, List<List<Boolean>> arr) {
        return curr.x >= 0 && curr.x < arr.size() &&
                curr.y >= 0 && curr.y < arr.get(curr.x).size() &&
                arr.get(curr.x).get(curr.y) == color;
    }

    public static void flipColor2(List<List<Boolean>> arr, Coordinate cur) {
        final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        boolean color = arr.get(cur.x).get(cur.y);
        arr.get(cur.x).set(cur.y, !color);
        for (int[] dir : dirs) {
            Coordinate next = new Coordinate(cur.x + dir[0], cur.y + dir[1]);
            if (isValid(next, color, arr)) {
                flipColor2(arr, next);
            }
        }
    }

    public static void test() {
        List<List<Boolean>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(false, true, false, true, true)));
        arr.add(new ArrayList<>(Arrays.asList(true, true, false, true, true)));
        arr.add(new ArrayList<>(Arrays.asList(false, false, false, true, false)));
        arr.add(new ArrayList<>(Arrays.asList(true, true, true, true, true)));
        arr.add(new ArrayList<>(Arrays.asList(true, false, true, true, true)));
        /*
        flipColor(arr, 4, 2);
        printArr(arr);
        flipColor(arr, 4, 2);
        printArr(arr);
        */
        flipColor2(arr, new Coordinate(4, 2));
        printArr(arr);
        flipColor2(arr, new Coordinate(4, 2));
        printArr(arr);
    }

    public static void printArr(List<List<Boolean>> arr) {
        System.out.println("");
        for (int i = 0; i < arr.size(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.get(0).size(); ++j) {
                sb.append(arr.get(i).get(j) ? "1 " : "0 ");
            }
            System.out.println(sb.toString());
        }
    }
}
