import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long[] numbers;
    private long[] answers;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new long[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        answers = new long[N + 1];
        answers[N] = -1;
        for (int i = N - 1; i >= 1; i--) {
            if (numbers[i] != numbers[i + 1]) {
                answers[i] = i + 1;
            } else {
                answers[i] = answers[i + 1];
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
