package Chapter18_Graphs;

import java.util.*;

public class Graphs_00_Dijkstras {

    public static void initializeSingleSource(List<CLRSGraphVertex> g, CLRSGraphVertex s) {
        for (CLRSGraphVertex v : g) {
            v.distance = Integer.MAX_VALUE;
            v.predecessor = null;
        }
        s.distance = 0;
    }

    public static void relax(CLRSGraphVertex u, CLRSGraphVertex v, SortedSet<CLRSGraphVertex> nodeSet) {
        if (v.distance > u.distance + u.weights.get(v)) {
            if (nodeSet.contains(v)) {
                nodeSet.remove(v);
            }
            v.distance = u.distance + u.weights.get(v);
            v.predecessor = u;

            nodeSet.add(v);
        }
    }

    public static void dijkstra(List<CLRSGraphVertex> g, CLRSGraphVertex s) {
        initializeSingleSource(g, s);
        SortedSet<CLRSGraphVertex> nodeSet = new TreeSet<>();
        Set<CLRSGraphVertex> set = new HashSet<>();
        for (CLRSGraphVertex u : g) {
            nodeSet.add(u);
        }
        while (!nodeSet.isEmpty()) {
            CLRSGraphVertex u = nodeSet.first();
            set.add(u);
            for (CLRSGraphVertex v : u.edges) {
                relax(u, v, nodeSet);
            }
            nodeSet.remove(nodeSet.first());
        }
    }

    public static void test() {
        CLRSGraphVertex s = new CLRSGraphVertex(0);
        CLRSGraphVertex t = new CLRSGraphVertex(1);
        CLRSGraphVertex x = new CLRSGraphVertex(2);
        CLRSGraphVertex y = new CLRSGraphVertex(3);
        CLRSGraphVertex z = new CLRSGraphVertex(4);

        // add edges
        s.edges.addAll(Arrays.asList(t, y));
        t.edges.addAll(Arrays.asList(x, y));
        x.edges.addAll(Arrays.asList(z));
        y.edges.addAll(Arrays.asList(t, x, z));
        z.edges.addAll(Arrays.asList(s, x));

        // add edge weights
        s.weights.put(t, 10);
        s.weights.put(y, 5);
        t.weights.put(x, 1);
        t.weights.put(y, 2);
        x.weights.put(z, 4);
        y.weights.put(t, 3);
        y.weights.put(z, 2);
        y.weights.put(x, 9);
        z.weights.put(s, 7);
        z.weights.put(x, 6);

        List<CLRSGraphVertex> g = new ArrayList<>(Arrays.asList(
                s, t, x, y, z
        ));
        dijkstra(g, s);

    }
}
