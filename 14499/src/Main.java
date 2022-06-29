import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int startX, startY;
    static int[][] map;
    static int[] dice;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    static void change(int dir) {
        //  1
        // 234
        //  5
        //  6
        int temp = dice[3];

        if (dir == 1) { // east
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        } else if (dir == 2) { // west
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (dir == 3) { // north
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] = temp;
        } else { // south;
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[7];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int newX = startX + dirX[dir - 1];
            int newY = startY + dirY[dir - 1];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
            change(dir);
            if (map[newX][newY] == 0) map[newX][newY] = dice[6];
            else {
                dice[6] = map[newX][newY];
                map[newX][newY] = 0;
            }

            startX = newX;
            startY = newY;

            sb.append(dice[3]).append('\n');
        }
        System.out.print(sb);
    }
}