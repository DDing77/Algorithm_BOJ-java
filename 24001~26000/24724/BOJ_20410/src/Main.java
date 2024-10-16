import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int m;
    private int seed;
    private int x1;
    private int x2;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        seed = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (x1 == (i * seed + j) % m && x2 == ((i * x1 + j) % m)) {
                    sb.append(i).append(" ").append(j);
                    System.out.println(sb);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
