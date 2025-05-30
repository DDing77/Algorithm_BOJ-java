import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private char[] input;

    private void solution() throws IOException {
        input = br.readLine().toCharArray();

        int cnt = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            if (cnt == 4) {
                stack.push(',');
                cnt = 1;
            }
            stack.push(input[i]);
            cnt++;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
