import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean visit[];
    static int arr[][];
    static int res;

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visit[1] = true;

        while (!que.isEmpty()) {
            res++;
            int val = que.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[val][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    que.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];
            visit = new boolean[N + 1];

            res = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u][v] = 1;
                arr[v][u] = 1;
            }

            bfs();

            sb.append(res - 1).append('\n');
        }
        System.out.print(sb);
    }
}
