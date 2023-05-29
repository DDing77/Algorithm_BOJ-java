import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private class Node {
        int x;
        int y;
        int number;
        int cnt;

        public Node(int x, int y, int number, int cnt) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.cnt = cnt;
        }
    }

    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N;
    private int[][] map;
    private boolean[][] isVisited;
    private int landNumber;
    private ArrayList<Node> edges;
    private int res;

    public void searchLand(int x, int y, int number) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, number, 0));
        isVisited = new boolean[N][N];
        isVisited[x][y] = true;
        boolean isEdge;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            map[cur.x][cur.y] = cur.number;

            isEdge = false;
            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dir[k][0];
                int nY = cur.y + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (!isEdge && map[nX][nY] == 0) {
                    isEdge = true;
                    edges.add(cur);
                }

                if (map[nX][nY] == 0) {
                    continue;
                }

                isVisited[nX][nY] = true;
                que.add(new Node(nX, nY, cur.number, 0));
            }
        }
    }

    public void getMinDistance(Node node, int numLand) {
        isVisited = new boolean[N][N];
        isVisited[node.x][node.y] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(node);

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dir[k][0];
                int nY = cur.y + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (!isVisited[nX][nY] && map[nX][nY] == 0) {
                    isVisited[nX][nY] = true;
                    que.add(new Node(nX, nY, cur.number, cur.cnt + 1));
                }

                if (map[nX][nY] != 0 && map[nX][nY] != numLand) {
                    res = Math.min(res, cur.cnt);
                    return;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        edges = new ArrayList<>();
        isVisited = new boolean[N][N];
        landNumber = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    searchLand(i, j, landNumber);
                    landNumber++;
                }
            }
        }

        res = Integer.MAX_VALUE;
        for (Node edge : edges) {
            getMinDistance(edge, map[edge.x][edge.y]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
