package Chapter18_Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex implements Comparable<GraphVertex> {

    @Override
    public int compareTo(GraphVertex o) {
        return 0;
    }

    public enum Color {white, gray, black}

    public Color color;
    public int id;
    public int distance = -1;
    public List<GraphVertex> edges = new ArrayList<>();
    public String stringData;
    public int maxDistance = 0;

    public GraphVertex() {
    }
    public GraphVertex(int id) {
        this.color = Color.white;
        this.id = id;
        edges = new ArrayList<>();
    }
}
