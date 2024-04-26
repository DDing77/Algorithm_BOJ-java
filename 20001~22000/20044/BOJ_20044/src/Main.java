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
    private int[] w;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        w = new int[N * 2];

        int length = w.length;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(w);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length / 2; i++) {
            res = Math.min(res, w[i] + w[length - i - 1]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
