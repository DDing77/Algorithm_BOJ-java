import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private PriorityQueue<int[]> edges;
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

        while (true) {

            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));


            for (int i = 0; i < N - 1; i++) {
                String[] tokens = br.readLine().split(" ");
                int from = tokens[0].charAt(0) - 'A';
                int edgeCnt = Integer.parseInt(tokens[1]);
                for (int j = 2; j < tokens.length; j += 2) {
                    int to = tokens[j].charAt(0) - 'A';
                    int weight = Integer.parseInt(tokens[j + 1]);
                    edges.add(new int[]{from, to, weight});
                }
            }

            parents = new int[N];
            Arrays.fill(parents, -1);

            int cnt = 0;
            res = 0;
            while (!edges.isEmpty()) {
                int[] edge = edges.poll();

                if (union(edge[0], edge[1])) {
                    cnt++;
                    res += edge[2];
                }
                if (cnt == N - 1) {
                    break;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
