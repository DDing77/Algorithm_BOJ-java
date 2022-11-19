import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] schedule;
    static int[] node;
    static ArrayList<Integer>[] adj;

    static int find(int x) {
        if (node[x] < 0) return x;
        return node[x] = find(node[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return;
        if (node[a] < node[b]) {
            node[a] += node[b];
            node[b] = a;
        } else {
            node[b] += node[a];
            node[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        schedule = new int[N + 1];
        node = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        Arrays.fill(node, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) schedule[i] = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i = 2; i <= N; i++) {
            if (find(schedule[i - 1]) != find(schedule[i])) res++;
        }

        System.out.println(res);
    }
}
