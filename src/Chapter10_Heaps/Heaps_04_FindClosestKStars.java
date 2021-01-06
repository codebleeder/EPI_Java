package Chapter10_Heaps;

import java.util.*;

public class Heaps_04_FindClosestKStars {
    private static class Star implements Comparable<Star> {
        public int x;
        public int y;
        public int z;

        public Star(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // distance from (0,0,0) to the star (x,y,z)
        public double getDistance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.getDistance(), o.getDistance());
        }

        public String toString() {
            return String.format("(%d,%d,%d) dist:%f", x, y, z, getDistance());
        }
    }

    private static List<Star> findClosestKStars(Iterator<Star> stars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while (stars.hasNext()) {
            maxHeap.add(stars.next());
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Star> res = new ArrayList<Star>(maxHeap);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>(
                Arrays.asList(
                        new Star(3, 2, 1),
                        new Star(1, 1, 7),
                        new Star(3, 3, 9),
                        new Star(8, 7, 2),
                        new Star(7, 1, 8),
                        new Star(2, 8, 9),
                        new Star(5, 5, 7),
                        new Star(2, 8, 9),
                        new Star(5, 5, 11),
                        new Star(23, 0, 0)
                )
        );

        List<Star> res = findClosestKStars(stars.iterator(), 4);
        for (Star star : res) {
            System.out.println(star.toString());
        }
    }
}
