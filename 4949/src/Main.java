import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            stack = new Stack<>();
            boolean flag = false;
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(0) == '.') {
                    flag = true;
                    break;
                }
                if (input.charAt(i) == '.') {
                    if (stack.isEmpty()) {
                        sb.append("yes").append('\n');
                    } else {
                        sb.append("no").append('\n');
                    }
                    break;
                }

                if (input.charAt(i) == '(') stack.push('(');
                if (input.charAt(i) == '[') stack.push('[');

                if (input.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        sb.append("no").append('\n');
                        break;
                    }
                }

                if (input.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        sb.append("no").append('\n');
                        break;
                    }
                }
            }
            if (flag) break;
        }
        System.out.print(sb);
    }
}
