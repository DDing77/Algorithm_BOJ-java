import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private class Node implements Comparable<Node> {
        int x;
        int y;
        int brokenCnt;

        public Node(int x, int y, int brokenCnt) {
            this.x = x;
            this.y = y;
            this.brokenCnt = brokenCnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.brokenCnt - o.brokenCnt;
        }
    }

    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N;
    private int M;
    private char[][] map;
    private int[][] broken;

    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        broken[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return;
            }

            if (broken[cur.x][cur.y] < cur.brokenCnt) {
                continue;
            }


            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dir[k][0];
                int nY = cur.y + dir[k][1];
                int nBrokenCnt = cur.brokenCnt;

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (map[nX][nY] == '1') {
                    nBrokenCnt++;
                }

                if (broken[nX][nY] <= nBrokenCnt) {
                    continue;
                }

                pq.add(new Node(nX, nY, nBrokenCnt));
                broken[nX][nY] = nBrokenCnt;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        broken = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(broken[i], Integer.MAX_VALUE);
            map[i] = br.readLine().toCharArray();
        }

        dijkstra();

        System.out.println(broken[N - 1][M - 1]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
