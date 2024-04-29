import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private int[] ops;
    private int resMin;
    private int resMax;

    private int calculate(int[] selectedOp) {

        int res = numbers[0];

        for (int i = 1; i < N; i++) {
            if (selectedOp[i - 1] == 0) {
                res += numbers[i];
            } else if (selectedOp[i - 1] == 1) {
                res -= numbers[i];
            } else if (selectedOp[i - 1] == 2) {
                res *= numbers[i];
            } else {
                res /= numbers[i];
            }
        }

        return res;
    }

    private void backTracking(int depth, int[] selectedOp) {

        if (depth == N - 1) {
            int res = calculate(selectedOp);
            resMin = Math.min(resMin, res);
            resMax = Math.max(resMax, res);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0) {
                selectedOp[depth] = i;
                ops[i]--;
                backTracking(depth + 1, selectedOp);
                ops[i]++;
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ops.length; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        resMin = Integer.MAX_VALUE;
        resMax = Integer.MIN_VALUE;

        backTracking(0, new int[N - 1]);

        sb.append(resMax).append("\n").append(resMin);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
