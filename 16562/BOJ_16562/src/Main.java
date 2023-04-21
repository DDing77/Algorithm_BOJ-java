import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int k;
    private int[] costs;
    private int[] parents;

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (costs[a] <= costs[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        costs = new int[N + 1];
        parents = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        int requireCost = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) {
                requireCost += costs[i];
            }
        }

        if (requireCost > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(requireCost);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
