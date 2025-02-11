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

        N = Integer.parseInt(br.readLine());
        edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        parents = new int[N];
        Arrays.fill(parents, -1);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);

                if ('a' <= ch && ch <= 'z') {
                    edges.add(new int[]{i, j, ch - 'a' + 1});
                    res += ch - 'a' + 1;
                } else if ('A' <= ch && ch <= 'Z') {
                    edges.add(new int[]{i, j, ch - 'A' + 27});
                    res += ch - 'A' + 27;
                }
            }
        }

        int cnt = 0;
        int sum = 0;
        while (!edges.isEmpty()) {
            int[] edge = edges.poll();
            if (union(edge[0], edge[1])) {
                cnt++;
                sum += edge[2];
            }

            if (cnt == N - 1) {
                break;
            }
        }

        if (cnt == N - 1) {
            System.out.println(res - sum);
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
