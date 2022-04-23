import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        stack = new Stack<>();

        int target;
        int lastValue = 0;
        for (int i = 1; i <= N; i++) {
            target = Integer.parseInt(br.readLine());
            if (lastValue > target && stack.peek() > target) {
                System.out.println("NO");
                return;
            }

            if (stack.isEmpty()) {
                while (lastValue < target) {
                    sb.append('+').append('\n');
                    stack.push(++lastValue);
                }
            }

            if (stack.peek() > target) {
                while (stack.peek() != target) {
                    sb.append('-').append('\n');
                    stack.pop();
                }
            } else if (stack.peek() < target) {
                while (lastValue < target) {
                    sb.append('+').append('\n');
                    stack.push(++lastValue);
                }
                sb.append('-').append('\n');
                stack.pop();
            } else {
                sb.append('-').append('\n');
                stack.pop();
                continue;
            }

        }
        System.out.print(sb);
    }
}
// 4 2