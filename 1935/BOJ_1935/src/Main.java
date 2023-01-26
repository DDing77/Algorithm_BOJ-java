import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static char[] input;
    static int[] numbers;
    static Stack<Double> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        stack = new Stack<>();
        for (char cur : input) {
            if ('A' <= cur && cur <= 'Z') {
                stack.push((double) numbers[cur - 'A']);
            } else {
                double temp;
                if (cur == '*') {
                    temp = 1;
                    temp *= stack.pop();
                    temp *= stack.pop();
                    stack.push(temp);
                } else if (cur == '/') {
                    double right = stack.pop();
                    double left = stack.pop();
                    stack.push(left / right);
                } else if (cur == '+') {
                    temp = 0;
                    temp += stack.pop();
                    temp += stack.pop();
                    stack.push(temp);
                } else if (cur == '-') {
                    double right = stack.pop();
                    double left = stack.pop();
                    stack.push(left - right);
                }
            }
        }

        System.out.println(String.format("%.2f",stack.pop()));

    }
}