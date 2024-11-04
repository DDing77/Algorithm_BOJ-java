import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static int[][] distance;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void dijkstra(int startX, int startY) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY});
        distance[startX][startY] = 1;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = now[0] + dir[k][0];
                int nY = now[1] + dir[k][1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                    continue;
                }

                if (distance[nX][nY] != 0) {
                    if (map[nX][nY] == 0) {
                        if (distance[nX][nY] > distance[now[0]][now[1]] + 1) {
                            distance[nX][nY] = distance[now[0]][now[1]] + 1;
                            que.add(new int[]{nX, nY});
                        }
                    } else {
                        if (distance[nX][nY] > distance[now[0]][now[1]]) {
                            distance[nX][nY] = distance[now[0]][now[1]];
                            que.add(new int[]{nX, nY});
                        }
                    }
                } else {
                    if (map[nX][nY] == 0) {
                        distance[nX][nY] = distance[now[0]][now[1]] + 1;
                    } else {
                        distance[nX][nY] = distance[now[0]][now[1]];
                    }
                    que.add(new int[]{nX, nY});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) map[i][j] = Integer.parseInt(input[j]);
        }

        dijkstra(0, 0);
        System.out.println(distance[N - 1][N - 1] - 1);
    }
}
