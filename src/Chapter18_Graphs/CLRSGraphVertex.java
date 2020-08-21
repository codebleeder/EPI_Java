package Chapter18_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLRSGraphVertex implements Comparable<CLRSGraphVertex> {
    public int id;
    public int distance;
    public String stringId = "";

    public List<CLRSGraphVertex> edges = new ArrayList<>();
    Map<CLRSGraphVertex, Integer> weights = new HashMap<>();

    public CLRSGraphVertex predecessor;

    public CLRSGraphVertex(int id) {
        this.id = id;
    }

    public CLRSGraphVertex(int id, String stringId) {
        this.id = id;
        this.stringId = stringId;
    }

    @Override
    public int compareTo(CLRSGraphVertex o) {
        //return Integer.compare(distance, o.distance);
        if (distance != o.distance) {
            return Integer.compare(distance, o.distance);
        }

        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return this.stringId + " id = " + this.id + " " + "distance = " + this.distance;
    }
}
