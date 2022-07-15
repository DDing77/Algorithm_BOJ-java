import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int remainCheese;
    static int res;
    static Queue<Info> cheese;

    static void getOutLine() {
        isVisited = new boolean[N][M];
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(0, 0));
        isVisited[0][0] = true;

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
                    isVisited[newX][newY] = true;
                    que.add(new Info(newX, newY));
                }
            }
        }
    }

    static void findCheese() {
        cheese = new LinkedList<>();
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                boolean canMelt = false;
                if (map[i][j] == 1) {
                    if (!canMelt) {
                        for (int k = 0; k < 4; k++) {
                            int newX = i + dx[k];
                            int newY = j + dy[k];
                            if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                            if (map[newX][newY] == 2) {
                                canMelt = true;
                                cheese.add(new Info(i, j));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    static void melt() {
        while (!cheese.isEmpty()) {
            Info cur = cheese.poll();
            map[cur.x][cur.y] = 2;
            remainCheese--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        remainCheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) remainCheese++;
            }
        }

        int pre = remainCheese;

        int day = 0;
        while (remainCheese > 0) {
            day++;
            pre = remainCheese;
            getOutLine();
            findCheese();
            melt();
        }
        System.out.println(day);
        System.out.println(pre);

    }
}