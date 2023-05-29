import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final String[] messages = {"LADICA", "SMECE"};
    static int N;
    static int L;
    static int[] parent;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        parent[a] = b;

        sb.append(messages[0]).append('\n');
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        parent = new int[L + 1];
        isVisited = new boolean[L + 1];

        for (int i = 1; i <= L; i++) {
            parent[i] = i;
        }

        int a;
        int b;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (!isVisited[a]) {
                isVisited[a] = true;
                union(a, b);
                continue;
            }

            if (!isVisited[b]) {
                isVisited[b] = true;
                union(b, a);
                continue;
            }

            if (!isVisited[find(parent[a])]) {
                isVisited[find(parent[a])] = true;
                union(a, b);
                continue;
            }

            if (!isVisited[find(parent[b])]) {
                isVisited[find(parent[b])] = true;
                union(b, a);
                continue;
            }

            sb.append(messages[1]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
