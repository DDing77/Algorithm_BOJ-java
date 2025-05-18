import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private int N;
    private int[] numbers;
    private char[] op;

    private void backTracking(int idx) {
        if (idx == N - 1) {
            StringBuilder expr = new StringBuilder();
            for (int i = 0; i < N; i++) {
                expr.append(numbers[i]);
                if (i < N - 1) {
                    expr.append(op[i]);
                }
            }

            if (evaluate(expr.toString().replace(" ", "")) == 0) {
                sb.append(expr).append("\n");
            }
            return;
        }

        op[idx] = ' ';
        backTracking(idx + 1);

        op[idx] = '+';
        backTracking(idx + 1);

        op[idx] = '-';
        backTracking(idx + 1);
    }

    private int evaluate(String expr) {
        int sum = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == expr.length() - 1) {
                if (sign == '+') sum += num;
                else if (sign == '-') sum -= num;

                sign = c;
                num = 0;
            }
        }

        return sum;
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = i + 1;
            }
            op = new char[N - 1];

            backTracking(0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
