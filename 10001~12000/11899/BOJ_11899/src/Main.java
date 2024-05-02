import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private int res;

    private void solution() throws IOException {

        Stack<Character> stack = new Stack<>();
        res = 0;
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                stack.add(cur);
            } else if (cur == ')') {
                if (stack.isEmpty()) {
                    res++;
                } else {
                    stack.pop();
                }
            }
        }

        res += stack.size();
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
