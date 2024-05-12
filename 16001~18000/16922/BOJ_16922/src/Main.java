import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    public static final int[] values = {1, 5, 10, 50};
    private int N;
    private boolean[] cache;
    private int res;

    private void backTracking(int idx, int depth, int sum) {
        if (depth == N) {
            if (!cache[sum]) {
                res++;
                cache[sum] = true;
            }
            return;
        }

        for (int i = idx; i < values.length; i++) {
            backTracking(i, depth + 1, sum + values[i]);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        cache = new boolean[50 * 50 + 1];
        res = 0;
        backTracking(0, 0, 0);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
