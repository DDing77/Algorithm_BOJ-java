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
    private int M;
    private int[] ranks;
    private int res;

    private int find(int x) {

        if (ranks[x] < 0) {
            return x;
        }
        return ranks[x] = find(ranks[x]);
    }

    private void union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            ranks[x] += ranks[y];
            ranks[y] = x;
        } else {
            ranks[y] += ranks[x];
            ranks[x] = y;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ranks = new int[N + 1];
        Arrays.fill(ranks, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            if (ranks[i] < 0) {
                res++;
            }
        }

        System.out.println(res - 1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
