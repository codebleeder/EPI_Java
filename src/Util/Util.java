package Util;

import java.util.Collection;
import java.util.Iterator;

public class Util {
    public static <T> void printCollection(Collection<T> c)
    {
        Iterator<T> iter = c.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()){
            sb.append(iter.next() + ", ");
        }
        System.out.println(sb.toString());
    }
}
