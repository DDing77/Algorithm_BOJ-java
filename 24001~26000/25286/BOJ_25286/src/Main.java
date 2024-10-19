import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int T;
    private int y;
    private int m;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (m == 1) {
                sb.append(y - 1).append(" ").append(12).append(" ").append(months[12]);
            } else {
                sb.append(y).append(" ").append(m - 1).append(" ");
                if (m == 3 && (y % 400 == 0 || (y % 100 != 0 && y % 4 == 0))) {
                    sb.append(29);
                } else {
                    sb.append(months[m - 1]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
