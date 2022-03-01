import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    static int[][] distance;
    static int[][] dir = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
    static void dijkstra(int startX, int startY) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        for(int i=0; i<N; i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        distance[0][0] = 0;

        while(!que.isEmpty()) {
            int nowX = que.poll();
            int nowY = que.poll();
            for(int k=0; k<4; k++) {
                int nX = nowX + dir[k][0];
                int nY = nowY + dir[k][1];
                if(nX <0 || nY <0 || nX >= N || nY >= N) continue;
                if(distance[nX][nY] <= distance[nowX][nowY]) continue;
                if(map[nX][nY] == 1) {
                    distance[nX][nY] = distance[nowX][nowY];
                    que.add(nX);
                    que.add(nY);
                } else {
                    que.add(nX);
                    que.add(nY);
                    distance[nX][nY] = distance[nowX][nowY] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        distance = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<input.length; j++) map[i][j] = Integer.parseInt(input[j]);
        }

        dijkstra(0,0);
        System.out.println(distance[N-1][N-1]);
    }
}
