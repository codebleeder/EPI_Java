package Chapter08_Stacks_and_Queues;

import java.util.*;

public class Stacks_and_Queues_03_TestParanthesis {
    public static boolean testParanthesis(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        final Set<Character> opening = new HashSet<>();
        opening.add('(');
        opening.add('{');
        opening.add('[');

        final Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (Character p : input.toCharArray()) {
            if (opening.contains(p)) {
                stack.addFirst(p);
            } else {
                char first = stack.removeFirst();
                if (map.get(first) != p) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{"{}()[]", "([]){()}", "[()[]{()()}]", "{)", "[()[]{()()"};
        for (String input : inputs) {
            System.out.println("input: " + input + "  res: " + testParanthesis(input));
        }
    }
}
