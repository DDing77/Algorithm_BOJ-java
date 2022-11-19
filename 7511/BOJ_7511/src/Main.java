import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int n, k;
    static int a, b;
    static int m, u, v;

    static int[] node;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            sb.append("Scenario " + (tc + 1) + ":" + '\n');

            n = Integer.parseInt(br.readLine());
            node = new int[n + 1];
            Arrays.fill(node, -1);

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                if (find(u) == find(v)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
