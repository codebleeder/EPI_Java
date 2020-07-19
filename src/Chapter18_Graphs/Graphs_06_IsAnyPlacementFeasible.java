package Chapter18_Graphs;

import java.util.*;

public class Graphs_06_IsAnyPlacementFeasible {
    public static boolean isAnyPlacementFeasible(List<GraphVertex> g) {
        for (GraphVertex v : g) {
            if (v.distance == -1 && !BFS(v)) {
                return false;
            }
        }
        return true;
    }

    public static boolean BFS(GraphVertex s) {
        s.distance = 0;
        Queue<GraphVertex> q = new LinkedList<>();
        s.distance = 0;
        q.add(s);
        while (!q.isEmpty()) {
            GraphVertex cur = q.peek();
            for (GraphVertex t : cur.edges) {
                if (t.distance == -1) {
                    t.distance = cur.distance + 1;
                    q.add(t);
                } else if (t.distance == cur.distance) {
                    return false;
                }
            }
            q.remove();
        }
        return true;
    }

    public static void test() {
        GraphVertex g0 = new GraphVertex(0);
        GraphVertex g1 = new GraphVertex(1);
        GraphVertex g2 = new GraphVertex(2);
        GraphVertex g3 = new GraphVertex(3);
        GraphVertex g4 = new GraphVertex(4);
        g0.edges.addAll(Arrays.asList(g1, g2));
        g1.edges.addAll(Arrays.asList(g0, g2, g3));
        g2.edges.addAll(Arrays.asList(g0, g1, g4));
        g3.edges.addAll(Arrays.asList(g0, g2, g3));
        List<GraphVertex> graph1 = new ArrayList<>(Arrays.asList(g0, g1, g2, g3, g4));
        System.out.println("test1 expected: false result: " + isAnyPlacementFeasible(graph1));

        GraphVertex v0 = new GraphVertex(0);
        GraphVertex v1 = new GraphVertex(1);
        GraphVertex v2 = new GraphVertex(2);
        GraphVertex v3 = new GraphVertex(3);
        GraphVertex v4 = new GraphVertex(4);
        GraphVertex v5 = new GraphVertex(5);

        v0.edges.addAll(Arrays.asList(v1, v2));
        v1.edges.addAll(Arrays.asList(v0, v3, v4));
        v2.edges.addAll(Arrays.asList(v0, v3));
        v3.edges.addAll(Arrays.asList(v1, v2, v5));
        v4.edges.addAll(Arrays.asList(v1, v5));
        v5.edges.addAll(Arrays.asList(v3, v4));
        List<GraphVertex> graph2 = new ArrayList<>(Arrays.asList(v0, v1, v2, v3, v4, v5));
        System.out.println("test1 expected: true result: " + isAnyPlacementFeasible(graph2));

    }
}
