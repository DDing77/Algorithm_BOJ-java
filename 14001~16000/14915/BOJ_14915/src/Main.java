import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private int N;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        if (M == 0) {
            System.out.println("0");
        } else {
            while (M > 0) {
                int remainder = M % N;
                if (remainder < 10) {
                    sb.append(remainder);
                } else {
                    sb.append((char) ('A' + (remainder - 10)));
                }
                M /= N;
            }
            System.out.println(sb.reverse());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
