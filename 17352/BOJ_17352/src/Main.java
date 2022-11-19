import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        node = new int[N + 1];
        Arrays.fill(node, -1);
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        for (int i = 2; i <= N; i++) {
            if (find(i - 1) != find(i)) {
                System.out.println((i - 1) + " " + i);
                return;
            }
        }
    }
}
