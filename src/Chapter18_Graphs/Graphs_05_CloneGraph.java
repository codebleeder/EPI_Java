package Chapter18_Graphs;

import java.util.*;

public class Graphs_05_CloneGraph {
    public static GraphVertex cloneGraph(GraphVertex g) {
        if (g == null) return null;

        Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> q = new LinkedList<>();
        q.add(g);
        vertexMap.put(g, new GraphVertex(g.id));
        while (!q.isEmpty()) {
            GraphVertex cur = q.poll();
            for (GraphVertex e : cur.edges) {
                if (!vertexMap.containsKey(e)) {
                    vertexMap.put(e, new GraphVertex(e.id));
                    q.add(e);
                }
                vertexMap.get(cur).edges.add(vertexMap.get(e));
            }
        }
        return vertexMap.get(g);
    }

    public static void test() {
        GraphVertex one = new GraphVertex(1);
        GraphVertex two = new GraphVertex(2);
        GraphVertex three = new GraphVertex(3);
        GraphVertex four = new GraphVertex(4);
        GraphVertex five = new GraphVertex(5);

        one.edges.addAll(Arrays.asList(two, five));
        two.edges.addAll(Arrays.asList(five, four, three));
        three.edges.addAll(Arrays.asList(two, four));
        four.edges.addAll(Arrays.asList(two, three, five));
        five.edges.addAll(Arrays.asList(one, two, four));

        GraphVertex cloned = cloneGraph(one);
    }
}
