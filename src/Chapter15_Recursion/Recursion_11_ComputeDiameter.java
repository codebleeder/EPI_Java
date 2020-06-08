package Chapter15_Recursion;

import Datastructures.Edge;
import Datastructures.TreeNode;

public class Recursion_11_ComputeDiameter {
    public static class HeightAndDiameter {
        public int height;
        public int diameter;

        public HeightAndDiameter(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int computeDiameter(TreeNode T) {
        return T != null ? helper(T).diameter : 0;
    }

    public static HeightAndDiameter helper(TreeNode r) {
        int diameter = Integer.MIN_VALUE;
        int[] heights = {0, 0};
        for (Edge e : r.edges) {
            HeightAndDiameter heightAndDiameter = helper(e.root);
            if (heightAndDiameter.height + e.length > heights[0]) {
                heights = new int[]{heightAndDiameter.height + e.length, heights[0]};
            } else if (heightAndDiameter.height + e.length > heights[1]) {
                heights[1] = heightAndDiameter.height + e.length;
            }
            diameter = Math.max(diameter, heightAndDiameter.diameter);
        }
        return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0] + heights[1]));
    }

    public static void test() {
        TreeNode root = buildTree();
        int diameter = computeDiameter(root);
        System.out.println("diameter = " + diameter);
    }

    private static TreeNode buildTree() {
        TreeNode b = new TreeNode(); // root
        TreeNode a = new TreeNode();
        TreeNode c = new TreeNode();
        TreeNode d = new TreeNode();
        TreeNode e = new TreeNode();
        TreeNode f = new TreeNode();
        TreeNode g = new TreeNode();
        TreeNode h = new TreeNode();
        TreeNode i = new TreeNode();
        TreeNode j = new TreeNode();
        TreeNode k = new TreeNode();
        TreeNode l = new TreeNode();
        TreeNode m = new TreeNode();
        TreeNode n = new TreeNode();
        TreeNode o = new TreeNode();
        TreeNode p = new TreeNode();

        d.edges.add(new Edge(e, 6));

        c.edges.add(new Edge(d, 4));
        c.edges.add(new Edge(f, 3));

        m.edges.add(new Edge(p, 1));
        m.edges.add(new Edge(o, 2));
        m.edges.add(new Edge(n, 3));

        k.edges.add(new Edge(l, 4));
        k.edges.add(new Edge(m, 2));

        i.edges.add(new Edge(j, 6));
        i.edges.add(new Edge(k, 4));

        g.edges.add(new Edge(h, 2));
        g.edges.add(new Edge(i, 1));

        b.edges.add(new Edge(c, 7));
        b.edges.add(new Edge(a, 14));
        b.edges.add(new Edge(g, 3));

        return b;
    }
}
