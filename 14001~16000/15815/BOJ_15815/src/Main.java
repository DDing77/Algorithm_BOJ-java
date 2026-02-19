import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private char[] input;
    private Stack<Integer> stack = new Stack<>();
    private int res;

    private void solution() throws IOException {
        input = br.readLine().toCharArray();

        for (char c : input) {
            if ('0' <= c && c <= '9') {
                stack.push(c - '0');
            } else if (c == '+') {
                int pre1 = stack.pop();
                int pre2 = stack.pop();
                stack.push(pre1 + pre2);
            } else if (c == '-') {
                int pre1 = stack.pop();
                int pre2 = stack.pop();
                stack.push(pre2 - pre1);
            } else if (c == '*') {
                int pre1 = stack.pop();
                int pre2 = stack.pop();
                stack.push(pre1 * pre2);
            } else if (c == '/') {
                int pre1 = stack.pop();
                int pre2 = stack.pop();
                stack.push(pre2 / pre1);
            }
        }

        System.out.println(stack.pop());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
