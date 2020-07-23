package Chapter18_Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {
    public enum Color {white, gray, black}

    public Color color;
    public int id;
    public int distance = -1;
    public List<GraphVertex> edges;
    public String stringData;

    public GraphVertex() {
    }
    public GraphVertex(int id) {
        this.color = Color.white;
        this.id = id;
        edges = new ArrayList<>();
    }
}
