import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Barn {
        private int idx;
        private int distance;

        public Barn(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    static Barn[] barns;
    static int N, M;
    static boolean[] isVisited;
    static ArrayList<Integer>[] adj;

    static void bfs(int start) {
        isVisited = new boolean[N + 1];
        Queue<Barn> que = new LinkedList<>();
        que.add(barns[start - 1]);
        isVisited[start] = true;

        while (!que.isEmpty()) {
            Barn cur = que.poll();

            for (int next : adj[cur.getIdx()]) {
                if (isVisited[next]) continue;
                isVisited[next] = true;
                barns[next - 1].setDistance(cur.getDistance() + 1);
                que.add(barns[next - 1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barns = new Barn[N];
        for (int i = 0; i < N; i++) barns[i] = new Barn(i + 1, 0);
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        bfs(1);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (barns[max].getDistance() < barns[i].getDistance()) {
                max = i;
            }
        }

        int resDistance = barns[max].getDistance();

        int sameCnt = 0;
        for (int i = 0; i < N; i++) {
            if (resDistance == barns[i].getDistance()) {
                sameCnt++;
            }
        }

        System.out.println(max + 1 + " " + resDistance + " " + sameCnt);
    }
}
