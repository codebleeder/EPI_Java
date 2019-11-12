package Chapter13_Sorting;

public class Sorting_07_Interval implements Comparable<Sorting_07_Interval> {
    public Sorting_07_Endpoint left = new Sorting_07_Endpoint();
    public Sorting_07_Endpoint right = new Sorting_07_Endpoint();
    public Sorting_07_Interval() {}
    public Sorting_07_Interval(Sorting_07_Endpoint left, Sorting_07_Endpoint right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Sorting_07_Interval o) {
        if (Integer.compare(left.val, o.left.val) != 0){
            return left.val - o.left.val;
        }
        return left.isClosed && !o.left.isClosed ? -1 : (!left.isClosed && o.left.isClosed ? 1 : 0);
    }
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof Sorting_07_Interval)) { return false; }
        if (this == o) { return true; }
        Sorting_07_Interval other = (Sorting_07_Interval) o;
        return left.val == other.left.val && left.isClosed == other.left.isClosed;
    }
    public String toString(){
        String leftBrace = left.isClosed ? "[" : "(";
        String rightBrace = right.isClosed ? "]" : ")";
        return String.format("%s%d, %d%s", leftBrace, left.val, right.val, rightBrace);
    }

}