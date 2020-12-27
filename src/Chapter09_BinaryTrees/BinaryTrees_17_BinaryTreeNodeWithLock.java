package Chapter09_BinaryTrees;

public class BinaryTrees_17_BinaryTreeNodeWithLock {
    public static class BinaryTreeNodeWithLock<T> {
        T data;
        BinaryTreeNodeWithLock<T> left, right, parent;
        Boolean locked = false;
        public int numLockedDescendents = 0;

        public BinaryTreeNodeWithLock() {
        }

        public BinaryTreeNodeWithLock(T data) {
            this.data = data;
        }

        public BinaryTreeNodeWithLock(T data, BinaryTreeNodeWithLock left, BinaryTreeNodeWithLock right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public boolean isLocked() {
            return locked;
        }

        public boolean lock() {
            // check no. of locked descendants and this lock property
            if (numLockedDescendents > 0 || isLocked()) {
                return false;
            }

            // check if any parent is locked:
            for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
                if (iter.locked) {
                    return false;
                }
            }

            // lock and update locked descendants of parent nodes
            this.locked = true;
            for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
                ++iter.numLockedDescendents;
            }

            return true;
        }

        public void unlock() {
            if (locked) {
                locked = false;
                for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
                    --iter.numLockedDescendents;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNodeWithLock<Integer> a = new BinaryTreeNodeWithLock<>(1);
        BinaryTreeNodeWithLock<Integer> b = new BinaryTreeNodeWithLock<>(2);
        BinaryTreeNodeWithLock<Integer> c = new BinaryTreeNodeWithLock<>(3);
        BinaryTreeNodeWithLock<Integer> d = new BinaryTreeNodeWithLock<>(4);
        BinaryTreeNodeWithLock<Integer> e = new BinaryTreeNodeWithLock<>(5);
        BinaryTreeNodeWithLock<Integer> f = new BinaryTreeNodeWithLock<>(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        b.parent = a;
        c.right = f;
        c.parent = a;
        d.parent = b;
        e.parent = b;
        f.parent = c;

        // lock b; a, d and e should not be able to lock
        System.out.println("lock b: " + b.lock()); // true
        System.out.println("lock a: " + a.lock()); // false
        System.out.println("lock e: " + e.lock()); // false
    }
}
