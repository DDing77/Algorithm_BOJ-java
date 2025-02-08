import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int Q;
    private int[] parents;
    private boolean[] check;
    private ArrayList<int[]> originEdges;
    private int doneCnt;

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
        if (check[x] && check[y]) {
            return false;
        }

        if (check[x] && !check[y]) {
            check[y] = true;
            doneCnt += parents[y];
        } else if (!check[x] && check[y]) {
            check[x] = true;
            doneCnt += parents[x];
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

    private void initialize() {

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        check = new boolean[N + 1];
        doneCnt = 2;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originEdges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            originEdges.add(new int[]{from, to, weight});
        }

        originEdges.sort(Comparator.comparingInt(o -> o[2]));

        ArrayList<int[]> mstEdges = new ArrayList<>();

        initialize();

        int cnt = 0;
        for (int[] edge : originEdges) {
            if (union(edge[0], edge[1])) {
                cnt++;
                mstEdges.add(edge);
            }

            if (cnt == N - 1) {
                break;
            }
        }

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            initialize();
            check[A] = true;
            check[B] = true;

            int sum = 0;
            for (int[] edge : mstEdges) {
                if (union(edge[0], edge[1])) {
                    sum += edge[2];
                }
                if (doneCnt == N) {
                    break;
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
