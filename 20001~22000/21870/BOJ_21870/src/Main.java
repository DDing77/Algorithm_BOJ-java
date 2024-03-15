import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] numbers;

    private int calculate(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return calculate(b, a % b);
    }

    private int getGCD(int left, int right) {
        int gcd = numbers[left];

        for (int i = left + 1; i <= right; i++) {
            gcd = calculate(gcd, numbers[i]);
        }

        return gcd;
    }

    private int recur(int left, int right) {
        if (left == right) {
            return numbers[left];
        }

        int mid = (left + right - 1) >> 1;
        int leftGCD = getGCD(left, mid);
        int rightGCD = getGCD(mid + 1, right);

        return Math.max(leftGCD + recur(mid + 1, right), recur(left, mid) + rightGCD);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(0, N - 1));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
