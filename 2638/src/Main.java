import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 내부 : 0
    // 치즈 : 1
    // 외부 : 2
    // 변경 : 3
    static int N, M;
    static int cheeseCnt;
    static int res;
    static int[][] map;
    static boolean[][] isVisited;
    //    static boolean[][] dirtyCheck;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 외부 영역 구하기
    static void getOut() {
        isVisited = new boolean[N][M];
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(0, 0));
        isVisited[0][0] = true;
        map[0][0] = 2;
        while (!que.isEmpty()) {
            Info cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int k = 0; k < 4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if (isVisited[newX][newY]) continue;
                if (map[newX][newY] != 1) {
                    map[newX][newY] = 2;
                    que.add(new Info(newX, newY));
                    isVisited[newX][newY] = true;
                }
            }
        }
    }

    static int getVoid(int x, int y) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
            // 기존에 치즈였던 공간이 빈공간으로 바뀌였으면 무시
            if (map[newX][newY] == 3) continue;
            if (map[newX][newY] == 2) {
                cnt++;
            }
        }
        return cnt;
    }

    static void getCheese() {
        Queue<Info> que = new LinkedList<>();
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    if (getVoid(i, j) > 1) {
                        que.add(new Info(i, j));
                    }
                }
            }
        }
        while (!que.isEmpty()) {
            Info cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            map[curX][curY] = 2;
        }
    }

    static void countCheese() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        cheeseCnt = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCnt++;
            }
        }

        res = 0;


        while (cheeseCnt > 0) {
            getOut();
            getCheese();
            res++;
            countCheese();
        }

//        getCheese();
//        res++;
//        System.out.println(cheeseCnt);
//        for(int i=0; i<N; i++) System.out.println(Arrays.toString(map[i]));
//
//        getCheese();
//        res++;
//        System.out.println(cheeseCnt);
//        for(int i=0; i<N; i++) System.out.println(Arrays.toString(map[i]));
        System.out.println(res);
    }
}