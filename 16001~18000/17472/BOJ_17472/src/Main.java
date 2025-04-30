import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int islandNumber = 1;

    private int N;
    private int M;
    private int[][] board;
    private boolean[][] isVisited;
    private ArrayList<ArrayList<Coordi>> outlines = new ArrayList<>();
    private int[] parents;
    private int res;
    private PriorityQueue<Edge> pq = new PriorityQueue<>();

    private ArrayList<Coordi> bfs(int x, int y, int islandNumber) {
        isVisited[x][y] = true;
        board[x][y] = islandNumber;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        Set<Integer> bfsOutlines = new HashSet<>();
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] == 0) {
                    bfsOutlines.add(cur[0] * M + cur[1]);
                    continue;
                }
                if (board[nX][nY] == -1) {
                    que.add(new int[]{nX, nY});
                    board[nX][nY] = islandNumber;
                    isVisited[nX][nY] = true;
                }
            }
        }

        ArrayList<Coordi> res = new ArrayList<>();
        for (int idx : bfsOutlines) {
            res.add(new Coordi(islandNumber, idx / M, idx % M));
        }
        return res;
    }

    private ArrayList<Edge> createEdge(Coordi coordi) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int[] dir : dirs) {
            int nX = coordi.x;
            int nY = coordi.y;
            while (true) {
                nX += dir[0];
                nY += dir[1];
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    break;
                }
                if (board[nX][nY] == coordi.number) {
                    break;
                }
                if (board[nX][nY] != 0) {
                    int weight = (coordi.x - nX + coordi.y - nY) - 1;
                    if (weight > 1) {
                        edges.add(new Edge(coordi.number, board[nX][nY], weight));
                    }
                    break;
                }
            }
        }
        return edges;
    }

    private int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (parents[x] < parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }
        return true;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    board[i][j] = -1;
                }
            }
        }

        outlines = new ArrayList<>();
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && board[i][j] == -1) {
                    ArrayList<Coordi> bfsOutlines = bfs(i, j, islandNumber);
                    outlines.add(bfsOutlines);
                    islandNumber++;
                }
            }
        }

        for (ArrayList<Coordi> outline : outlines) {
            for (Coordi coordi : outline) {
                ArrayList<Edge> edges = createEdge(coordi);
                for (Edge edge : edges) {
                    pq.add(edge);
                }
            }
        }

        if (pq.isEmpty()) {
            System.out.println(-1);
            return;
        }

        parents = new int[islandNumber];
        Arrays.fill(parents, -1);

        int count = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.a, edge.b)) {
                res += edge.weight;
                count++;
            }
            if (count == islandNumber - 2) {
                break;
            }
        }

        if (count != islandNumber - 2) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Coordi {

        int number;
        int x;
        int y;

        public Coordi(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {

        int a;
        int b;
        int weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
