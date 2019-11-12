package Chapter13_Sorting;

public  class Sorting_07_Endpoint implements Comparable<Sorting_07_Endpoint>{
    public boolean isClosed;
    public int val;

    public Sorting_07_Endpoint(){}
    public Sorting_07_Endpoint(int val, boolean isClosed){
        this.val = val;
        this.isClosed = isClosed;
    }
    @Override
    public int compareTo(Sorting_07_Endpoint o) {
        if (Integer.compare(val, o.val) != 0){
            return val - o.val;
        }
        return isClosed && !o.isClosed ? -1 : (!isClosed && o.isClosed ? 1 : 0);
    }
}

