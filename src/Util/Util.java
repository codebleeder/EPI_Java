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

    public static <T> void printArr(T[] c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; ++i) {
            sb.append(c[i] + ", ");
        }
        System.out.println(sb.toString());
    }

    public static void printArr(int[] c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; ++i) {
            sb.append(c[i] + ", ");
        }
        System.out.println(sb.toString());
    }

    public static void test() {
        int[] x = {1, 2, 3};
        printArr(x);
    }
}
