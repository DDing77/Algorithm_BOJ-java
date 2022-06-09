import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, M;
    static int[] left, right;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    static boolean DFS(int from) {
        visited[from] = true;
        for (int i = 0; i < adj[from].size(); i++) {
            int to = adj[from].get(i);
            if (right[to] == -1 || (!visited[right[to]] && DFS(right[to]))) {
                left[from] = to;
                right[to] = from;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            adj = new ArrayList[1005];
            for (int i = 0; i < 1005; i++) adj[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
            }

            int match = 0;
            left = new int[1005];
            right = new int[1005];
            Arrays.fill(left, -1);
            Arrays.fill(right, -1);

            for(int i=0; i<N; i++) {
                visited = new boolean[1005];
                if(DFS(i)) match++;
            }
            sb.append(match).append('\n');
        }
        System.out.print(sb);
    }
}
