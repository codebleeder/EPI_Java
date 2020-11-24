package Chapter08_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Stacks_and_Queues_02_EvaluateRPNExpression {
    public static int evaluateRPNExpression(String expression) {
        int res = 0;
        String[] list = expression.split(",");

        // case 1: single or multiple digits
        if (list.length == 1) {
            return Integer.parseInt(list[0]);
        }

        // case 2: comma separated numbers and operations
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : list) {

            if (token.length() == 1 && "+-*/".contains(token)) {
                int x = stack.removeFirst();
                int y = stack.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        stack.addFirst(x + y);
                        break;
                    case '-':
                        stack.addFirst(x - y);
                        break;
                    case '*':
                        stack.addFirst(x * y);
                        break;
                    case '/':
                        stack.addFirst(x / y);
                        break;
                }
            } else {
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.removeFirst();
    }

    public static void main(String[] args) {
        String[] cases = new String[]{"6", "-42", "3,4,+,2,*,1,+", "1,1,+,-2,*"};
        for (String input : cases) {
            System.out.println("input: " + input + "  res: " + evaluateRPNExpression(input));
        }
    }
}
