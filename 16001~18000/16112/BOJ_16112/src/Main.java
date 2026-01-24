import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] expArr;
    private long resSum;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        expArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            expArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(expArr);

        resSum = 0L;
        int curAlive = 0;
        for (int i = 0; i < N; i++) {
            resSum += (long) expArr[i] * curAlive;
            curAlive = Math.min(K, ++curAlive);
        }

        System.out.println(resSum);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
