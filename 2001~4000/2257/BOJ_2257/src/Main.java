import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final HashMap<Character, Integer> map = new HashMap<>();

    private Stack<Integer> stack = new Stack<>();
    private int res;

    private void init() {
        map.put('H', 1);
        map.put('C', 12);
        map.put('O', 16);
    }

    private void solution() throws IOException {
        init();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else if (c == ')') {
                int sum = 0;
                while (stack.peek() != 0) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(sum);
            } else if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                int newValue = stack.pop() * (c - '0');
                stack.push(newValue);
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
