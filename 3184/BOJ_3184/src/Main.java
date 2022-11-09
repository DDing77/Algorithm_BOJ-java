import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int curSheep, curWolf;
    static int resSheep, resWolf;

    public static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        isVisited[x][y] = true;

        curSheep = 0;
        curWolf = 0;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            if (map[curX][curY] == 'o') curSheep++;
            if (map[curX][curY] == 'v') curWolf++;

            for (int k = 0; k < 4; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) continue;
                if (isVisited[nX][nY]) continue;
                if (map[nX][nY] == '#') continue;

                que.add(nX);
                que.add(nY);
                isVisited[nX][nY] = true;
            }
        }

        if (curSheep > curWolf) resSheep += curSheep;
        else resWolf += curWolf;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isVisited = new boolean[R][C];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        resSheep = 0;
        resWolf = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(resSheep + " " + resWolf);
    }
}
