import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int C;
    private int B;
    private int[] buckets;
    private int res;

    private void backTracking(int depth, int sum) {

        if (depth == B) {
            res = Math.max(res, sum);
            return;
        }

        int nSum = sum + buckets[depth];

        backTracking(depth + 1, sum);

        if (nSum <= C) {
            backTracking(depth + 1, nSum);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        buckets = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            buckets[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
