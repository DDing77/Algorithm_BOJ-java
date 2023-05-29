import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[] depth;
    static int[] parent;
    static HashMap<String, Integer> map;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            depth[x] += depth[y];
        }

        return depth[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            depth = new int[N * 2];
            parent = new int[N * 2];
            map = new HashMap<>();

            for (int i = 0; i < N * 2; i++) {
                depth[i] = 1;
                parent[i] = i;
            }

            int idx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                if (!map.containsKey(from)) map.put(from, idx++);
                if (!map.containsKey(to)) map.put(to, idx++);

                sb.append(union(map.get(from), map.get(to))).append('\n');
            }
        }
        System.out.print(sb);
    }
}
