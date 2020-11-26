package Chapter08_Stacks_and_Queues;

import java.util.*;

public class Stacks_and_Queues_04_NormalizePathName {
    public static String shortestEquivalentPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        if (path.startsWith("/")) {
            stack.addFirst("/");
        }
        for (String s : dirs) {
            if (s.equals("..")) {
                if (stack.isEmpty() || stack.peekFirst().equals("..")) {
                    stack.addFirst(s);
                } else {
                    if (stack.peekFirst().equals("/")) {
                        throw new IllegalArgumentException("path error: trying to go up the root: " + path);
                    }
                    stack.removeFirst();
                }
            } else if (!s.equals(".") && !s.isEmpty()) {
                stack.addFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!stack.isEmpty()) {
            Iterator<String> it = stack.descendingIterator();
            String prev = it.next();
            sb.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    sb.append("/");
                }
                prev = it.next();
                sb.append(prev);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>(Arrays.asList(
                "/p1/p2/../p3/p4/../p5",
                "p1/p2/../p3/p4/../p5",
                "p1/p2/././../p3"
        ));
        for (String input : inputs) {
            System.out.println("input: " + input + "   res: " + shortestEquivalentPath(input));
        }

        // should throw error:
        shortestEquivalentPath("/abc/../..");
    }
}
