import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Coordinate {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Coordinate(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }

    static int N, M;

    static char[][] map;
    static boolean[][][][] isVisited;
    static int min = Integer.MAX_VALUE;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void bfs(Coordinate ball) {
        Queue<Coordinate> que = new LinkedList<>();
        que.add(ball);
        isVisited[ball.redX][ball.redY][ball.blueX][ball.blueY] = true;

        while (!que.isEmpty()) {
            Coordinate curBall = que.poll();
            int curCnt = curBall.cnt;

            if (curCnt >= 10) return;
            for (int k = 0; k < 4; k++) {
                int newRedX = curBall.redX;
                int newRedY = curBall.redY;
                int newBlueX = curBall.blueX;
                int newBlueY = curBall.blueY;

                //빨간 구슬 이동
                while (map[newRedX + dir[k][0]][newRedY + dir[k][1]] != '#') {
                    newRedX += dir[k][0];
                    newRedY += dir[k][1];
                    if (map[newRedX][newRedY] == 'O') break;
                }

                while (map[newBlueX + dir[k][0]][newBlueY + dir[k][1]] != '#') {
                    newBlueX += dir[k][0];
                    newBlueY += dir[k][1];
                    if (map[newBlueX][newBlueY] == 'O') break;
                }

                if (map[newBlueX][newBlueY] == 'O') continue;

                if (map[newRedX][newRedY] == 'O') {
                    min = Math.min(min, curCnt + 1);
                    return;
                }

                // 빨간 파랑 만났을 때
                if (newRedX == newBlueX && newRedY == newBlueY && map[newRedX][newRedY] != 'O') {
                    int redDistance = Math.abs(newRedX - curBall.redX) + Math.abs(newRedY - curBall.redY);
                    int blueDistance = Math.abs(newBlueX - curBall.blueX) + Math.abs(newBlueY - curBall.blueY);

                    if (redDistance > blueDistance) {
                        newRedX -= dir[k][0];
                        newRedY -= dir[k][1];
                    } else {
                        newBlueX -= dir[k][0];
                        newBlueY -= dir[k][1];
                    }
                }

                if (!isVisited[newRedX][newRedY][newBlueX][newBlueY]) {
                    isVisited[newRedX][newRedY][newBlueX][newBlueY] = true;
                    que.add(new Coordinate(newRedX, newRedY, newBlueX, newBlueY, curCnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];

        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (map[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }
        bfs(new Coordinate(redX, redY, blueX, blueY, 0));
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
