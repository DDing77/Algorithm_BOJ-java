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
    private int M;
    private char[] sexual;
    private int[] parents;
    private int res;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int x, int y) {

        if (sexual[x] == sexual[y]) {
            return false;
        }

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sexual = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sexual[i] = st.nextToken().charAt(0);
        }

        parents = new int[N];
        Arrays.fill(parents, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new int[]{from, to, weight});
        }

        int cnt = 0;
        boolean isMst = false;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            if (union(edge[0], edge[1])) {
                cnt++;
                res += edge[2];
            }

            if (cnt == N - 1) {
                isMst = true;
                break;
            }
        }


        if (isMst) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
