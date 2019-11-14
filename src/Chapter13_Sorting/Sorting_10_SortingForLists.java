package Chapter13_Sorting;
import Chapter07_LinkedLists.LinkedLists_01_MergeTwoSortedLists;
import Chapter07_LinkedLists.ListNode;
import Util.Util;

import java.util.*;


public class Sorting_10_SortingForLists {
    public static ListNode<Integer> insertionSort(final ListNode<Integer> L){
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> iter = L;
        while (iter != null && iter.next != null){
            if (iter.data > iter.next.data){
                ListNode<Integer> target = iter.next;
                iter.next = target.next;
                ListNode<Integer> iter2 = dummyHead;
                while (iter2.next.data < target.data){
                    iter2 = iter2.next;
                }
                // swap
                ListNode<Integer> temp = iter2.next;
                iter2.next = target;
                target.next = temp;
            }
            else {
                iter = iter.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode<Integer> stableSortList(ListNode<Integer> L){
        if (L == null || L.next == null){
            return L;
        }
        // split
        ListNode<Integer> slow = L;
        ListNode<Integer> fast = L;
        ListNode<Integer> preSlow = null;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;
        return LinkedLists_01_MergeTwoSortedLists.mergeTwoSortedLists(stableSortList(L),
                stableSortList(slow));
    }

    public static void test(){
        List<Integer> testArr = new ArrayList<>();
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        Random r = new Random();
        ListNode<Integer> iter = dummyHead;
        for (int i = 0; i < 10; i++){
            int n = r.nextInt(100);
            testArr.add(n);
            iter.next = new ListNode<Integer>(n);
            iter = iter.next;
        }
        ListNode<Integer> res = stableSortList(dummyHead.next);

        StringBuilder sb = new StringBuilder();
        for (int i: testArr){
            sb.append(i + ", ");
        }
        System.out.println("input list: " + sb.toString());
        System.out.println("result: ");
        ListNode.printLinkedList(res);
    }
    public static List<Integer> mergeSort(List<Integer> arr){
        if (arr.size() <= 1){
            return arr;
        }
        return mergeSortedArrays(mergeSort(arr.subList(0, arr.size()/2)),
                mergeSort(arr.subList(arr.size()/2, arr.size())));
    }
    public static List<Integer> mergeSortedArrays(List<Integer> a, List<Integer> b){
        int iA = 0, iB = 0;
        List<Integer> res = new ArrayList<>();
        while (iA < a.size() && iB < b.size()){
            if (a.get(iA) < b.get(iB)){
                res.add(a.get(iA));
                iA++;
            }
            else {
                res.add(b.get(iB));
                iB++;
            }
        }
        if (iA == a.size() && iB < b.size()){
            res.addAll(b.subList(iB, b.size()));
        }
        else if (iA < a.size() && iB == b.size()){
            res.addAll(a.subList(iA, a.size()));
        }
        return res;
    }
    public static void testMergeSortArr(){
        List<Integer> arr = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            arr.add(r.nextInt(100));
        }
        System.out.println("input: ");
        Util.printCollection(arr);
        List<Integer> res = mergeSort(arr);
        System.out.println("result");
        Util.printCollection(res);
    }
}
