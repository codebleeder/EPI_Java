package Chapter18_Graphs;

import java.util.*;

public class Graphs_03_FillSurroundedRegions {
    public static void fillSurroundedRegions(List<List<Character>> board) {
        for (int i = 0; i < board.size(); ++i) {
            if (board.get(i).get(0) == 'w') {
                markBoundaryRegion(i, 0, board);
            }
            if (board.get(i).get(board.size() - 1) == 'w') {
                markBoundaryRegion(i, board.size() - 1, board);
            }
        }

        for (int j = 0; j < board.size(); ++j) {
            if (board.get(0).get(j) == 'w') {
                markBoundaryRegion(0, j, board);
            }
            if (board.get(board.size() - 1).get(j) == 'w') {
                markBoundaryRegion(board.size() - 1, j, board);
            }
        }

        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.get(i).size(); ++j) {
                char val = board.get(i).get(j);
                board.get(i).set(j, val != 't' ? 'b' : 'w');
            }
        }
    }

    public static boolean isValid(Coordinate curr, char c, List<List<Character>> arr) {
        return curr.x >= 0 && curr.x < arr.size() &&
                curr.y >= 0 && curr.y < arr.get(curr.x).size() &&
                arr.get(curr.x).get(curr.y) == c;
    }

    public static final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void markBoundaryRegion(int row, int col, List<List<Character>> board) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(row, col));
        while (!q.isEmpty()) {
            Coordinate cur = q.poll();
            if (isValid(cur, 'w', board)) {
                board.get(cur.x).set(cur.y, 't');
                for (int[] d : dirs) {
                    q.add(new Coordinate(cur.x + d[0], cur.y + d[1]));
                }
            }
        }
    }

    public static void test() {
        List<List<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(Arrays.asList('b', 'b', 'b', 'b')));
        board.add(new ArrayList<>(Arrays.asList('w', 'b', 'w', 'b')));
        board.add(new ArrayList<>(Arrays.asList('b', 'w', 'w', 'b')));
        board.add(new ArrayList<>(Arrays.asList('b', 'b', 'b', 'b')));
        System.out.println("before fill: ");
        printBoard(board);

        fillSurroundedRegions(board);
        System.out.println("after fill: ");
        printBoard(board);
    }

    public static void printBoard(List<List<Character>> board) {
        for (List<Character> l : board) {
            StringBuilder sb = new StringBuilder();
            for (Character c : l) {
                sb.append(c + " ");
            }
            System.out.println(sb.toString());
        }
    }
}
