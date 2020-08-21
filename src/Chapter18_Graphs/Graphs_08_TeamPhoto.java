package Chapter18_Graphs;

import java.util.*;

public class Graphs_08_TeamPhoto {
    public static int findLargestNumberTeams(List<GraphVertex> g) {
        return findLongestPath(buildTopologicalOrdering(g));
    }

    private static Deque<GraphVertex> buildTopologicalOrdering(List<GraphVertex> g) {
        Deque<GraphVertex> orderedGraph = new ArrayDeque<>();
        for (GraphVertex v : g) {
            if (v.maxDistance == 0) {
                dfs(v, orderedGraph);
            }
        }
        return orderedGraph;
    }

    private static void dfs(GraphVertex cur, Deque<GraphVertex> orderedGraph) {
        cur.maxDistance = 1;
        for (GraphVertex v : cur.edges) {
            if (v.maxDistance == 0) {
                dfs(v, orderedGraph);
            }
        }
        orderedGraph.addFirst(cur);
    }

    private static int findLongestPath(Deque<GraphVertex> orderedGraph) {
        int maxDistance = 0;
        while (!orderedGraph.isEmpty()) {
            GraphVertex u = orderedGraph.peekFirst();
            maxDistance = Math.max(maxDistance, u.maxDistance);
            for (GraphVertex v : u.edges) {
                v.maxDistance = Math.max(v.maxDistance, u.maxDistance + 1);
            }
            orderedGraph.removeFirst();
        }
        return maxDistance;
    }

    public static void test() {
        // build a DAG
        /*
        1 -> 2, 3, 6
        2 -> 4, 5
        3 -> 6
        4 -> 7
        5 -> 8
        6 -> 7
        7 -> 8
         */
        GraphVertex one = new GraphVertex();
        one.id = 1;
        GraphVertex two = new GraphVertex();
        two.id = 2;
        GraphVertex three = new GraphVertex();
        three.id = 3;
        GraphVertex four = new GraphVertex();
        four.id = 4;
        GraphVertex five = new GraphVertex();
        five.id = 5;
        GraphVertex six = new GraphVertex();
        six.id = 6;
        GraphVertex seven = new GraphVertex();
        seven.id = 7;
        GraphVertex eight = new GraphVertex();
        eight.id = 8;

        one.edges.addAll(Arrays.asList(two, three, six));
        two.edges.addAll(Arrays.asList(four, five));
        three.edges.addAll(Arrays.asList(six));
        four.edges.addAll(Arrays.asList(seven));
        five.edges.addAll(Arrays.asList(eight));
        six.edges.addAll(Arrays.asList(seven));
        seven.edges.add(eight);
        List<GraphVertex> dag = new ArrayList<>(Arrays.asList(one, two, three, four,
                five, six, seven, eight));
        System.out.println("max distance expected = 5  result = " + findLargestNumberTeams(dag));
    }
}
