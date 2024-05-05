import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int X;
    private int Y;
    private int N;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (i % X == 0) {
                if (i % Y == 0) {
                    sb.append("FizzBuzz");
                } else {
                    sb.append("Fizz");
                }
            } else {
                if (i % Y == 0) {
                    sb.append("Buzz");
                } else {
                    sb.append(i);
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
