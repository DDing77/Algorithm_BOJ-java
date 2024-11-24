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
    private int[] debts;
    private int[] parents;
    private int[] sums;

    private int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        debts = new int[N];
        for (int i = 0; i < N; i++) {
            debts[i] = Integer.parseInt(br.readLine());
        }

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                parents[find(a)] = find(b);
            }
        }

        sums = new int[N];
        for (int i = 0; i < N; i++) {
            sums[find(i)] += debts[i];
        }

        for (int i = 0; i < N; i++) {
            if (sums[i] != 0) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println("POSSIBLE");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
