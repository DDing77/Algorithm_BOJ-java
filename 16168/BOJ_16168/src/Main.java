import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int V;
    private int E;
    private int[] nodes;
    private int[] degrees;

    public int find(int x) {
        if (nodes[x] < 0) {
            return x;
        }
        return nodes[x] = find(nodes[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (nodes[a] <= nodes[b]) {
            nodes[a] += nodes[b];
            nodes[b] = a;
        } else {
            nodes[b] += nodes[a];
            nodes[a] = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new int[V + 1];
        Arrays.fill(nodes, -1);

        degrees = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            degrees[from]++;
            degrees[to]++;

            union(from, to);
        }

        int sets = 0;
        int odd = 0;
        for (int i = 1; i <= V; i++) {
            if (nodes[i] < 0) {
                sets++;
            }
            if (degrees[i] % 2 == 1) {
                odd++;
            }
        }

        if (sets == 1 && (odd == 0 || odd == 2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
