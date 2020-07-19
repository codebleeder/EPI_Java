package Chapter18_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphs_04_HasCycle {
    public static class GraphVertex {
        public enum Color {white, gray, black}

        public Color color;
        public List<GraphVertex> edges;

        public GraphVertex() {
            this.color = Color.white;
        }
    }

    public static boolean isDeadlocked(List<GraphVertex> g) {
        for (GraphVertex v : g) {
            if (v.color == GraphVertex.Color.white && hasCycle(v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(GraphVertex cur) {
        if (cur.color == GraphVertex.Color.gray) {
            return true;
        }
        cur.color = GraphVertex.Color.gray;
        if (cur.edges != null) {
            for (GraphVertex next : cur.edges) {
                if (next.color != GraphVertex.Color.black && hasCycle(next)) {
                    return true;
                }
            }
        }

        cur.color = GraphVertex.Color.black;
        return false;
    }

    public static void test() {
        GraphVertex one = new GraphVertex();
        GraphVertex two = new GraphVertex();
        GraphVertex three = new GraphVertex();
        GraphVertex four = new GraphVertex();
        GraphVertex five = new GraphVertex();
        GraphVertex six = new GraphVertex();

        one.edges = new ArrayList<>(Arrays.asList(two, four));
        two.edges = new ArrayList<>(Arrays.asList(five));
        three.edges = new ArrayList<>(Arrays.asList(five, six));
        four.edges = new ArrayList<>(Arrays.asList(two));
        five.edges = new ArrayList<>(Arrays.asList(four));

        List<GraphVertex> graph = new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
        System.out.println("expected: true  result: " + isDeadlocked(graph));

        four.edges = new ArrayList<>();
        // reset color
        for (GraphVertex v : graph) {
            v.color = GraphVertex.Color.white;
        }
        System.out.println("expected: false  result: " + isDeadlocked(graph));
    }
}
