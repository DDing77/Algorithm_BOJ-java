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

    private int N;
    private int M;
    private int[] aArr;
    private int resMax;

    private void execDFS(int idx, int score, int count) {
        if (count == M || idx == N) {
            resMax = Math.max(resMax, score);
            return;
        }

        if (idx + 1 <= N) {
            execDFS(idx + 1, score + aArr[idx + 1], count + 1);
        }
        if (idx + 2 <= N) {
            execDFS(idx + 2, score / 2 + aArr[idx + 2], count + 1);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        aArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        execDFS(0, 1, 0);

        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
