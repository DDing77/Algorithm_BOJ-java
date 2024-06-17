import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++) {
                if (Integer.parseInt(st.nextToken()) == (j - 1) % 5 + 1) {
                    count++;
                }
            }

            if (count == 10) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
