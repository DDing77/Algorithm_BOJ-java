import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String input;
    static Stack<Character> stack;

    public static int getPriority(char op) {
        if (op == '/' || op == '*') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        stack = new Stack<>();

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if ('A' <= cur && cur <= 'Z') sb.append(cur);
            else if (cur == '(') stack.push(cur);
            else if (cur == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(cur)) {
                    sb.append(stack.pop());
                }
                stack.push(cur);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}

