import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] parents;
    private PriorityQueue<int[]> edges;
    private int resCost;
    private ArrayList<int[]> resPath;

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

        parents = new int[N];
        Arrays.fill(parents, -1);

        edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (j >= i) {
                    st.nextToken();
                    continue;
                }

                int cost = Integer.parseInt(st.nextToken());

                if (cost < 0) {
                    resCost += cost * -1;
                    if (union(i, j)) {
                        cnt++;
                    }
                } else {
                    edges.add(new int[]{i, j, cost});
                }
            }
        }

        int nCnt = 0;
        resPath = new ArrayList<>();
        while (!edges.isEmpty() && cnt < N) {
            int[] edge = edges.poll();

            if (union(edge[0], edge[1])) {
                cnt++;
                nCnt++;
                resCost += edge[2];
                resPath.add(edge);
            }
        }

        sb.append(resCost).append(" ").append(nCnt).append("\n");
        for (int[] edge : resPath) {
            sb.append(edge[1] + 1).append(" ").append(edge[0] + 1).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
