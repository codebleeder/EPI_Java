package Chapter18_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DijkstraGraphVertex implements Comparable<DijkstraGraphVertex> {

    public static class VertexWithDistance {
        public DijkstraGraphVertex vertex;
        public Integer distance;

        public VertexWithDistance(DijkstraGraphVertex vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static class DistanceWithFewestEdges {
        public Integer distance;
        public Integer minNumEdges;

        public DistanceWithFewestEdges(Integer distance, Integer minNumEdges) {
            this.distance = distance;
            this.minNumEdges = minNumEdges;
        }
    }

    public DistanceWithFewestEdges distanceWithFewestEdges
            = new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
    public List<VertexWithDistance> edges = new ArrayList<>();
    public int id;
    public DijkstraGraphVertex pred = null;

    @Override
    public int compareTo(DijkstraGraphVertex o) {
        if (distanceWithFewestEdges.distance != o.distanceWithFewestEdges.distance) {
            return Integer.compare(distanceWithFewestEdges.distance,
                    o.distanceWithFewestEdges.distance);
        }
        if (distanceWithFewestEdges.minNumEdges != o.distanceWithFewestEdges.minNumEdges) {
            return Integer.compare(distanceWithFewestEdges.minNumEdges,
                    o.distanceWithFewestEdges.minNumEdges);
        }
        return Integer.compare(id, o.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DijkstraGraphVertex)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DijkstraGraphVertex that = (DijkstraGraphVertex) obj;
        return id == that.id &&
                distanceWithFewestEdges.distance.equals(that.distanceWithFewestEdges.distance) &&
                distanceWithFewestEdges.minNumEdges.equals(that.distanceWithFewestEdges.minNumEdges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceWithFewestEdges.distance, distanceWithFewestEdges.minNumEdges, id);
    }
}
