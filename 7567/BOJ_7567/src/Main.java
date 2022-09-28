import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String input;
    static Stack<Character> stack;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        stack = new Stack<>();
        res = 0;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (stack.isEmpty()) {
                res += 10;
                stack.push(cur);
            } else {
                if (cur == stack.peek()) res += 5;
                else res += 10;
                stack.push(cur);
            }
        }
        System.out.println(res);
    }
}
