import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    long K;
    int from;
    int to;

    private void hanoi(int size, long K, int a, int b, int c) {

        long mid = (long) Math.pow(2, size - 1);

        if (mid < K) {
            hanoi(size - 1, K - mid, b, a, c);
        } else if (mid > K) {
            hanoi(size - 1, K, a, c, b);
        } else {
            from = a;
            to = c;
            return;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        hanoi(N, K, 1, 2, 3);

        sb.append(from).append(" ").append(to);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
