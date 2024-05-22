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
    private int[] diff;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        diff = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            diff[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }

        Arrays.sort(diff);

        if (N % 2 == 1) {
            System.out.println(1);
        } else {
            System.out.println(Math.abs(diff[N / 2] - diff[N / 2 - 1]) + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
