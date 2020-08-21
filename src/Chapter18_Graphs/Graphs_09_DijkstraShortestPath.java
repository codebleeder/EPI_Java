package Chapter18_Graphs;

import java.util.*;

public class Graphs_09_DijkstraShortestPath {
    public static void relax(CLRSGraphVertex u, CLRSGraphVertex v, SortedSet<CLRSGraphVertex> nodeSet) {
        if (v.distance > u.distance + u.weights.get(v) + 1) {
            if (nodeSet.contains(v)) {
                nodeSet.remove(v);
            }
            v.distance = u.distance + u.weights.get(v) + 1;
            v.predecessor = u;

            nodeSet.add(v);
        }
    }

    public static void dijkstra(List<CLRSGraphVertex> g, CLRSGraphVertex s) {
        Graphs_00_Dijkstras.initializeSingleSource(g, s);
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

    public static void outputShortestPath(CLRSGraphVertex v) {
        if (v != null) {
            outputShortestPath(v.predecessor);
            System.out.println(v.toString());
        }
    }

    public static void test() {
        CLRSGraphVertex a = new CLRSGraphVertex(0, "a");
        CLRSGraphVertex b = new CLRSGraphVertex(1, "b");
        CLRSGraphVertex c = new CLRSGraphVertex(2, "c");
        CLRSGraphVertex d = new CLRSGraphVertex(3, "d");
        CLRSGraphVertex e = new CLRSGraphVertex(4, "e");
        CLRSGraphVertex f = new CLRSGraphVertex(5, "f");
        CLRSGraphVertex g = new CLRSGraphVertex(6, "g");
        CLRSGraphVertex h = new CLRSGraphVertex(7, "h");
        CLRSGraphVertex i = new CLRSGraphVertex(8, "i");
        CLRSGraphVertex j = new CLRSGraphVertex(9, "j");
        CLRSGraphVertex k = new CLRSGraphVertex(10, "k");
        CLRSGraphVertex l = new CLRSGraphVertex(11, "l");

        // add edges
        a.edges.addAll(Arrays.asList(b, c));
        b.edges.addAll(Arrays.asList(a, k));
        c.edges.addAll(Arrays.asList(e));
        d.edges.addAll(Arrays.asList(c, h));
        e.edges.addAll(Arrays.asList(d));
        f.edges.addAll(Arrays.asList(g));
        g.edges.addAll(Arrays.asList(f, h));
        i.edges.addAll(Arrays.asList(j));
        j.edges.addAll(Arrays.asList(f, l));
        k.edges.addAll(Arrays.asList(i));
        l.edges.addAll(Arrays.asList(i));

        // add edge weights
        a.weights.put(b, 3);
        a.weights.put(c, 2);

        b.weights.put(a, 4);
        b.weights.put(k, 1);


        c.weights.put(e, 8);

        d.weights.put(c, 5);
        d.weights.put(h, 5);

        e.weights.put(d, 7);

        f.weights.put(g, 6);

        g.weights.put(f, 7);
        g.weights.put(h, 4);

        i.weights.put(j, 6);

        j.weights.put(f, 1);
        j.weights.put(l, 7);

        k.weights.put(i, 1);

        l.weights.put(i, 9);

        List<CLRSGraphVertex> graph = new ArrayList<>(Arrays.asList(
                a, b, c, d, e, f, g, h, i, k, l
        ));
        dijkstra(graph, a);
        outputShortestPath(h);
    }
}
