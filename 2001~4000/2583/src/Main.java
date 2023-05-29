import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static ArrayList<Integer> list = new ArrayList<>();
    static int groupCnt = 0;

    static void DFS(int x, int y) {
        isVisited[x][y] = true;
        groupCnt++;
        for(int k=0; k<4; k++) {
            int nX = x + dirX[k];
            int nY = y + dirY[k];
            if(nX <0 || nY <0 || nX >= M || nY >= N) continue;
            if(isVisited[nX][nY]) continue;
            if(map[nX][nY] == 1) continue;
            DFS(nX, nY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && isVisited[i][j] == false) {
                    groupCnt=0;
                    DFS(i,j);
                    list.add(groupCnt);
                }
            }
        }
       sb.append(list.size());
        Collections.sort(list);
        sb.append('\n');
        for(int size : list) sb.append(size).append(" ");
        System.out.print(sb);
    }
}
