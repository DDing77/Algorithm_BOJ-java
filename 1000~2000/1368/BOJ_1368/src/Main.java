import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private PriorityQueue<int[]> que;
    private int[] parents;
    private int res;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (parents[x] <= parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }

        return true;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        que = new PriorityQueue<>(Comparator.comparing(a -> a[2]));

        for (int i = 1; i <= N; i++) {
            que.add(new int[]{0, i, Integer.parseInt(br.readLine())});
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (weight != 0) {
                    que.add(new int[]{i, j, weight});
                }
            }
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);
        int cnt = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (union(cur[0], cur[1])) {
                cnt++;
                res += cur[2];
            }

            if (cnt == N) {
                break;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
