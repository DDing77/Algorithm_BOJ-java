import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static int K;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sum -= stack.peek();
                stack.pop();
            } else {
                stack.push(input);
                sum += input;
            }
        }
        System.out.println(sum);
    }
}