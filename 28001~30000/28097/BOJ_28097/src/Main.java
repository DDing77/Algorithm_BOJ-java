import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int N;
    int sum;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                sum += 8;
            }
            sum += Integer.parseInt(st.nextToken());
        }

        sb.append(sum / 24).append(" ").append(sum % 24);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
