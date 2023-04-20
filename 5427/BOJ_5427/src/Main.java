import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final String MESSAGE = "IMPOSSIBLE";
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int T;
    private int w;
    private int h;
    private char[][] map;
    private Queue<Node> fire;
    private Queue<Node> human;

    private int res;

    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public boolean isOver(int x, int y) {
        if (x < 0 || x >= h || y < 0 || y >= w) {
            return false;
        }

        return true;
    }

    public void execBFS() {
        int size;

        while (!human.isEmpty()) {

            size = fire.size();

            for (int i = 0; i < size; i++) {
                Node cur = fire.poll();

                for (int k = 0; k < 4; k++) {
                    int nX = cur.x + dir[k][0];
                    int nY = cur.y + dir[k][1];

                    if (!isOver(nX, nY)) {
                        continue;
                    }

                    if (map[nX][nY] != '.') {
                        continue;
                    }

                    map[nX][nY] = '*';
                    fire.add(new Node(nX, nY));
                }
            }

            size = human.size();
            for (int i = 0; i < size; i++) {
                Node cur = human.poll();
                for (int k = 0; k < 4; k++) {
                    int nX = cur.x + dir[k][0];
                    int nY = cur.y + dir[k][1];

                    if (!isOver(nX, nY)) {
                        res = cur.cnt + 1;
                        return;
                    }

                    if (map[nX][nY] != '.') {
                        continue;
                    }

                    map[nX][nY] = '@';
                    human.add(new Node(nX, nY, cur.cnt + 1));
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            fire = new LinkedList<>();
            human = new LinkedList<>();

            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') {
                        human.add(new Node(i, j, 0));
                    }

                    if (map[i][j] == '*') {
                        fire.add(new Node(i, j));
                    }
                }
            }

            res = -1;
            execBFS();

            if (res == -1) {
                sb.append(MESSAGE);
            } else {
                sb.append(res);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
