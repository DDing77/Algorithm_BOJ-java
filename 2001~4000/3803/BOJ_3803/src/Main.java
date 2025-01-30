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

    private int P;
    private int R;
    private int[] parents;
    private PriorityQueue<int[]> edges;
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

        edges = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        while (true) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());

            if (P == 0) {
                break;
            }
            R = Integer.parseInt(st.nextToken());

            parents = new int[P + 1];
            Arrays.fill(parents, -1);

            edges.clear();
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                edges.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            res = 0;
            while (!edges.isEmpty()) {
                int[] edge = edges.poll();

                if (union(edge[0], edge[1])) {
                    cnt++;
                    res += edge[2];
                }

                if (cnt == P - 1) {
                    break;
                }
            }

            sb.append(res).append("\n");

            br.readLine();
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
