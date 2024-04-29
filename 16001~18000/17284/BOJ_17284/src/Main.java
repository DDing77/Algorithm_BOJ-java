import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int res;

    private void solution() throws IOException {

        res = 5_000;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                res -= 500;
            } else if (type == 2) {
                res -= 800;
            } else {
                res -= 1_000;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
