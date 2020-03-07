package Chapter15_Recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Recursion_01_TowerOfHanoi {
    private static final int NUM_PEGS = 3;
    public static void computeTowerOfHanoi(int numRings){
        // setup
        List<Deque<Integer>> pegs = new ArrayList<>();
        for(int i = 0; i < NUM_PEGS; i++){
            pegs.add(new LinkedList<Integer>());
        }
        for(int i = numRings; i >= 1; i--){
            pegs.get(0).addFirst(i);
        }

        compute(numRings, pegs, 0, 2, 1);
    }
    public static void compute(int numRingsToMove,
                        List<Deque<Integer>> pegs,
                        int fromPeg,
                        int toPeg,
                        int usePeg){
        if(numRingsToMove > 0){
            compute(numRingsToMove-1, pegs, fromPeg, usePeg, toPeg);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from peg" + fromPeg + " to peg" + toPeg);
            compute(numRingsToMove-1, pegs, usePeg, toPeg, fromPeg);
        }
    }
    public static void test(){
        computeTowerOfHanoi(5);
    }
}
