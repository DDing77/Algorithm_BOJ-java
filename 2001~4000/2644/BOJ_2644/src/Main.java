import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int cur;
        int cnt;

        public Info(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int a, b;
    static ArrayList<Integer>[] edges;
    static boolean[][] isVisited;
    static int res;

    static void bfs() {
        res = -1;
        Queue<Info> que = new LinkedList<>();

        for (int next : edges[a]) {
            que.add(new Info(next, 1));
            isVisited[a][next] = true;
        }

        while (!que.isEmpty()) {
            Info cur = que.poll();
            if (cur.cur == b) {
                res = cur.cnt;
                return;
            }

            for (int next : edges[cur.cur]) {
                if (isVisited[cur.cur][next] || isVisited[next][cur.cur]) continue;
                que.add(new Info(next, cur.cnt + 1));
                isVisited[cur.cur][next] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        isVisited = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }
        bfs();
        System.out.println(res);
    }
}
