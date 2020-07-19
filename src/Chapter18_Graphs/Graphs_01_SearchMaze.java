package Chapter18_Graphs;

import java.util.*;

public class Graphs_01_SearchMaze {
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", this.x, this.y);
        }
    }

    public static enum Color {WHITE, BLACK}

    public static List<Coordinate> searchMaze(List<List<Color>> maze,
                                              Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        if (!helper(maze, s, e, path)) {
            return Collections.EMPTY_LIST;
        }
        return path;
    }

    public static boolean helper(List<List<Color>> maze, Coordinate curr, Coordinate e,
                                 List<Coordinate> path) {
        if (!isFeasible(curr, maze)) {
            return false;
        }
        path.add(curr);
        maze.get(curr.x).set(curr.y, Color.BLACK);
        if (curr.equals(e)) {
            return true;
        }

        final int[][] SHIFT = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] s : SHIFT) {
            if (helper(maze, new Coordinate(curr.x + s[0], curr.y + s[1]), e, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static boolean isFeasible(Coordinate curr, List<List<Color>> maze) {
        return curr.x >= 0 && curr.x < maze.size() &&
                curr.y >= 0 && curr.y < maze.get(curr.x).size() &&
                maze.get(curr.x).get(curr.y) == Color.WHITE;
    }

    public static void test() {
        List<List<Color>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE)));
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK)));
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE)));
        maze.add(new ArrayList<>(Arrays.asList(Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE)));
        List<Coordinate> path = searchMaze(maze, new Coordinate(3, 0), new Coordinate(0, 3));

        System.out.println("path: ");
        for (Coordinate cell : path) {
            System.out.println(cell.toString());
        }
    }


}
