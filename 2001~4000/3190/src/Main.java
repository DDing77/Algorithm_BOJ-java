import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, L;
    static int[][] map;
    static HashMap<Integer, Integer> dirList;
    static List<Info> snake;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int getNextDir(int cur, int dir) {
        int next = (cur + dir) % 4;
        if (next == -1) next = 3;
        return next;
    }

    static int solution() {
        int cnt = 0;
        int turn = 0;
        snake = new LinkedList<>();
        snake.add(new Info(0, 0));
        int curX = 0;
        int curY = 0;
        int curDir = 0;

        while (true) {

            cnt++;
            int nextX = curX + dx[curDir];
            int nextY = curY + dy[curDir];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) break;

            boolean meet = false;
            for (int i = 0; i < snake.size(); i++) {
                Info info = snake.get(i);
                if (info.x == nextX && info.y == nextY) {
                    meet = true;
                    break;
                }
            }
            if (meet) break;
            if (map[nextX][nextY] == 1) snake.add(new Info(nextX, nextY));
            else {
                snake.add(new Info(nextX, nextY));
                snake.remove(0);
            }
//            System.out.println("idx : " + nextX + " : " + nextY);
            curX = nextX;
            curY = nextY;

            if (dirList.containsKey(cnt)) {
                int nextDir = dirList.get(cnt);
                if (nextDir == 1) {
                    curDir += 1;
                    if (curDir == 4) curDir = 0;
                } else {
                    curDir -= 1;
                    if (curDir == -1) curDir = 3;
                }
            }
//            System.out.println(curDir);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        dirList = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            if (dir.equals("L")) dirList.put(number, -1);
            else dirList.put(number, 1);
        }
        int res = solution();
        System.out.println(res);
    }
}