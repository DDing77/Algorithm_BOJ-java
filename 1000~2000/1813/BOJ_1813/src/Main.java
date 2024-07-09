import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] counts;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        counts = new int[51];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            counts[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = N; i >= 0; i--) {
            if (i == counts[i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
