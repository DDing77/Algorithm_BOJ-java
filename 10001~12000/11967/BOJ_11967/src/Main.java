import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int M;
    private ArrayList<Node>[][] edges;
    private boolean[][] isVisited;
    private boolean[][] isLightRoom;
    private int res;


    private void execBFS() {
        isVisited = new boolean[N][N];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        isVisited[0][0] = true;

        boolean newAreaFlag = false;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (Node node : edges[cur[0]][cur[1]]) {
                if (!isLightRoom[node.x][node.y]) {
                    isLightRoom[node.x][node.y] = true;
                    res++;
                    newAreaFlag = true;
                }
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (!isLightRoom[nX][nY]) {
                    continue;
                }
                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }

        if (newAreaFlag) {
            execBFS();
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edges[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            edges[a][b].add(new Node(c, d));
        }

        isLightRoom = new boolean[N][N];
        isLightRoom[0][0] = true;
        execBFS();

        System.out.println(res + 1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
