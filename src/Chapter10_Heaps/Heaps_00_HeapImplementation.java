package Chapter10_Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heaps_00_HeapImplementation {
    public static class PQ<T extends Comparable<T>> {
        private T[] pq;
        private int N = 0;

        public PQ() {

        }

        // with initial capacity:
        public PQ(int max) {
            pq = (T[]) new Comparable[max + 1];
        }

        public PQ(T[] arr) {
            pq = (T[]) new Comparable[arr.length + 1];
            for (int i = 0; i < arr.length; ++i) {
                insert(arr[i]);
            }
        }

        public void insert(T data) {
            pq[++N] = data;
            swim(N);
        }

        public T remove() {
            T top = pq[1];
            swap(1, N--);
            pq[N + 1] = null;
            sink(1);
            return top;
        }

        public T peek() {
            return pq[1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        // helper functions:
        private void swap(int i, int j) {
            T temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }

        private void swim(int n) {
            while (n > 1 && less(n / 2, n)) {
                swap(n / 2, n);
                n = n / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                swap(k, j);
                k = j;
            }
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }
    }

    public static void main(String[] args) {
        // max heap
        Integer[] arr = new Integer[]{3, 2, 1, 7, 8};
        PQ<Integer> pq = new PQ(arr);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
