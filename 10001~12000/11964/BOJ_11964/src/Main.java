import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int A;
    private int B;
    private boolean[][] isVisited;

    private int resMax;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        resMax = 0;
        isVisited = new boolean[T + 1][2];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            resMax = Math.max(resMax, cur[0]);

            int next = cur[0] + A;
            if (next <= T && !isVisited[next][cur[1]]) {
                isVisited[next][cur[1]] = true;
                que.add(new int[]{next, cur[1]});
            }

            next = cur[0] + B;
            if (next <= T && !isVisited[next][cur[1]]) {
                isVisited[next][cur[1]] = true;
                que.add(new int[]{next, cur[1]});
            }

            if (cur[1] == 0) {
                next = cur[0] / 2;
                if (next <= T && !isVisited[next][1]) {
                    isVisited[next][1] = true;
                    que.add(new int[]{next, 1});
                }
            }

        }

        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
