import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] value;
    private int[] rank;
    private PriorityQueue<Integer> remainCountries;

    public int find(int x) {
        if (rank[x] < 0) {
            return x;
        }

        return rank[x] = find(rank[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (rank[a] <= rank[b]) {
            rank[a] += rank[b];
            value[a] += value[b];
            rank[b] = a;
        } else {
            rank[b] += rank[a];
            value[b] += value[a];
            rank[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        value = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rank[i] = -1;
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (op == 1) {
                union(from, to);
            } else {
                int aParent = find(from);
                int bParent = find(to);
                if (value[aParent] == value[bParent]) {
                    rank[aParent] = aParent;
                    rank[bParent] = bParent;
                } else if (value[aParent] > value[bParent]) {
                    value[aParent] -= value[bParent];
                    value[bParent] = 0;
                    union(aParent, bParent);
                } else {
                    value[bParent] -= value[aParent];
                    value[aParent] = 0;
                    union(aParent, bParent);
                }
            }
        }

        remainCountries = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (rank[i] < 0) {
                remainCountries.add(value[i]);
            }
        }

        sb.append(remainCountries.size()).append('\n');
        while (!remainCountries.isEmpty()) {
            sb.append(remainCountries.poll() + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
