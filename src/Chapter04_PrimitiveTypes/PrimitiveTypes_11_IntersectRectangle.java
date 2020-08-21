package Chapter04_PrimitiveTypes;

import Util.Tuple;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypes_11_IntersectRectangle {
    public static class Rectangle {
        public int x;
        public int y;
        public int height;
        public int width;

        public Rectangle() {
        }

        public Rectangle(int x, int y, int height, int width) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
        }

        @Override
        public String toString() {
            return String.format("x=%d\ty=%d\twidth=%d\theight=%d", x, y, width, height);
        }
    }

    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
        Rectangle leftRect;
        Rectangle rightRect;
        if (r1.x < r2.x) {
            leftRect = r1;
            rightRect = r2;
        } else {
            leftRect = r2;
            rightRect = r1;
        }
        if (rightRect.x > leftRect.x + leftRect.width) {
            return null; // no intersection
        }
        Rectangle result = new Rectangle();
        result.x = rightRect.x;
        result.width = Math.min(leftRect.x + leftRect.width, rightRect.x + rightRect.width) - result.x;

        Rectangle bottomRect;
        Rectangle topRect;
        if (r1.y < r2.y) {
            bottomRect = r1;
            topRect = r2;
        } else {
            bottomRect = r2;
            topRect = r1;
        }
        if (topRect.y > bottomRect.y + bottomRect.height) {
            return null;
        }
        result.y = topRect.y;
        result.height = Math.min(bottomRect.y + bottomRect.height, topRect.y + topRect.height) - result.y;

        return result;
    }

    // book solution:
    public static Rectangle intersectRectangle2(Rectangle r1, Rectangle r2) {
        if (!isIntersect(r1, r2)) {
            return null;
        }
        return new Rectangle(
                Math.max(r1.x, r2.x),
                Math.max(r1.y, r2.y),
                Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y),
                Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x)
        );
    }

    public static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x &&
                r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y;
    }

    public static void test() {
        List<Tuple<Rectangle>> inputs = new ArrayList<>();
        inputs.add(
                new Tuple<Rectangle>(
                        new Rectangle(2, 3, 4, 6),
                        new Rectangle(5, 5, 4, 7)
                )
        );
        inputs.add(
                new Tuple<Rectangle>(
                        new Rectangle(2, 2, 3, 5),
                        new Rectangle(3, 1, 6, 2)
                )
        );
        for (Tuple<Rectangle> input : inputs) {
            Rectangle result = intersectRectangle(input.item1, input.item2);
            if (result != null) {
                System.out.println(result.toString());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
