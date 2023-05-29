import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int ansX, ansY;
    static int[][] score;
    static boolean[][] isVisited;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static Queue<Integer> resQue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            ansX = Integer.parseInt(st.nextToken());
            ansY = Integer.parseInt(st.nextToken());
            resQue.add(ansX);
            resQue.add(ansY);
        }


        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        isVisited[startX][startY] = true;
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 8; k++) {
                int nX = x + dir[k][0];
                int nY = y + dir[k][1];

                if (nX < 1 || nY < 1 || nX > N || nY > N) continue;
                if (isVisited[nX][nY]) continue;

                score[nX][nY] = score[x][y] + 1;
                isVisited[nX][nY] = true;
                que.add(nX);
                que.add(nY);
            }
        }

        for(int i =0; i<M; i++) {
            int x = resQue.poll();
            int y = resQue.poll();
            sb.append(score[x][y]).append(" ");
        }
        System.out.println(sb);
    }
}
