import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private char[] input;
    private int[] numbers;
    private char[] ops;
    private int res;

    private int calculate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a- b;
        } else {
            return a * b;
        }
    }

    private void execDFS(int preSum, int opIdx) {
        if (opIdx == ops.length) {
            res = Math.max(res, preSum);
            return;
        }

        int calRes = calculate(preSum, numbers[opIdx + 1], ops[opIdx]);
        execDFS(calRes, opIdx + 1);

        if (opIdx + 1 < ops.length) {
            calRes = calculate(numbers[opIdx + 1], numbers[opIdx + 2], ops[opIdx + 1]);
            execDFS(calculate(preSum, calRes, ops[opIdx]), opIdx + 2);
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        numbers = new int[input.length / 2 + 1];
        ops = new char[input.length / 2];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = input[i] - '0';
            } else {
                ops[i / 2] = input[i];
            }
        }

        res = Integer.MIN_VALUE;
        execDFS(numbers[0], 0);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
