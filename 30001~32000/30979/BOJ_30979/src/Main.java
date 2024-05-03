import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            res += Integer.parseInt(st.nextToken());
        }

        if (res >= T) {
            System.out.println("Padaeng_i Happy");
        } else {
            System.out.println("Padaeng_i Cry");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
