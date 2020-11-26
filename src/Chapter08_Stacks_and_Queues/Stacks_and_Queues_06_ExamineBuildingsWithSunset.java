package Chapter08_Stacks_and_Queues;

import java.util.*;

public class Stacks_and_Queues_06_ExamineBuildingsWithSunset {
    public static class BuildingWithHeight {
        public int id;
        public int height;

        public BuildingWithHeight(int id, int height) {
            this.id = id;
            this.height = height;
        }

        @Override
        public String toString() {
            return "id= " + this.id + ",  height= " + this.height;
        }
    }

    public static Deque<BuildingWithHeight> examineBuildingWithSunset(Iterator<BuildingWithHeight> seq) {
        Deque<BuildingWithHeight> stack = new ArrayDeque<>();
        while (seq.hasNext()) {
            BuildingWithHeight curr = seq.next();
            if (stack.isEmpty()) {
                stack.addFirst(curr);
            } else {
                if (stack.peekFirst().height < curr.height) {
                    // remove until height greater than curr is encountered
                    while (!stack.isEmpty() && stack.peekFirst().height < curr.height) {
                        stack.pollFirst();
                    }
                }
                stack.addFirst(curr);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        List<BuildingWithHeight> list = new ArrayList<>(Arrays.asList(
                new BuildingWithHeight(0, 2),
                new BuildingWithHeight(1, 4),
                new BuildingWithHeight(2, 5),
                new BuildingWithHeight(3, 3),
                new BuildingWithHeight(4, 2),
                new BuildingWithHeight(5, 4),
                new BuildingWithHeight(6, 2)
        ));
        Deque<BuildingWithHeight> res = examineBuildingWithSunset(list.iterator());
        while (!res.isEmpty()) {
            BuildingWithHeight curr = res.pollFirst();
            if (curr != null) {
                System.out.println(curr.toString());
            }

        }
    }
}
