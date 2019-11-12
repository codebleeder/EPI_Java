package Chapter13_Sorting;

public class Name implements Comparable<Name> {
    String first;
    String last;
    Name(String first, String last){
        this.first = first;
        this.last = last;
    }
    @Override
    public int compareTo(Name o) {
        int cmpFirst = first.compareTo(o.first);
        if (cmpFirst != 0) { return cmpFirst; }
        return last.compareTo(o.last);
    }
    public String toString(){
        return String.format("first: %s  last: %s", first, last);
    }
}
