import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    String input;
    Stack<Character> stack;
    int count;

    private void solution() throws IOException {

        int tc = 1;
        while (true) {
            input = br.readLine();
            if (input.contains("-")) {
                break;
            }

            count = 0;
            int length = input.length();
            stack = new Stack<>();
            for (int i = 0; i < length; i++) {
                char cur = input.charAt(i);
                if (cur == '{') {
                    stack.add(cur);
                } else if (stack.isEmpty() && cur == '}') {
                    count++;
                    stack.add('{');
                } else if (!stack.isEmpty() && cur == '}') {
                    stack.pop();
                }
            }

            count += stack.size() / 2;
            sb.append(tc++).append(". ").append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
