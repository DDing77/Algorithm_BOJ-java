import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_SIZE = 500;
    private static final int INF = (MAX_SIZE + 1) * (MAX_SIZE + 1);
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int[][] edges = new int[MAX_SIZE + 1][MAX_SIZE + 1];
    private int[][] distances = new int[MAX_SIZE + 1][MAX_SIZE + 1];
    private int res;

    private void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        distances[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.distance > distances[cur.x][cur.y]) {
                continue;
            }

            if (cur.x == MAX_SIZE && cur.y == MAX_SIZE) {
                return;
            }

            for (int[] dir : dirs) {
                int nextX = cur.x + dir[0];
                int nextY = cur.y + dir[1];

                if (nextX < 0 || nextX > MAX_SIZE || nextY < 0 || nextY > MAX_SIZE) {
                    continue;
                }

                if (edges[nextX][nextY] == -1) {
                    continue;
                }

                if (cur.distance + edges[nextX][nextY] < distances[nextX][nextY]) {
                    distances[nextX][nextY] = cur.distance + edges[nextX][nextY];
                    pq.add(new Node(nextX, nextY, distances[nextX][nextY]));
                }
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int lx = Math.min(x1, x2);
            int rx = Math.max(x1, x2);
            int ly = Math.min(y1, y2);
            int ry = Math.max(y1, y2);

            for (int j = lx; j <= rx; j++) {
                for (int k = ly; k <= ry; k++) {
                    edges[j][k] = 1;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int lx = Math.min(x1, x2);
            int rx = Math.max(x1, x2);
            int ly = Math.min(y1, y2);
            int ry = Math.max(y1, y2);

            for (int j = lx; j <= rx; j++) {
                for (int k = ly; k <= ry; k++) {
                    edges[j][k] = -1;
                }
            }
        }

        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[i].length; j++) {
                distances[i][j] = INF;
            }
        }

        dijkstra();

        res = distances[MAX_SIZE][MAX_SIZE];
        if (res == INF) {
            res = -1;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
