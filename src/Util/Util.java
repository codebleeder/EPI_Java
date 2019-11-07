package Util;

import java.util.Collection;
import java.util.Iterator;

public class Util {
    public static <T> void printCollection(Collection<T> c)
    {
        Iterator<T> iter = c.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
