import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int B;
    private int[] cows;
    private int res;

    private void execDFS(int cur, int sumHeight) {

        if (sumHeight >= B) {
            res = Math.min(res, sumHeight - B);
            return;
        }

        for (int i = cur; i < N; i++) {
            execDFS(i + 1, sumHeight + cows[i]);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        res = Integer.MAX_VALUE;

        execDFS(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

