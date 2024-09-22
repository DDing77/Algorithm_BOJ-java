import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (T-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }

            if (sum == number) {
                sb.append("Perfect");
            } else if (sum < number) {
                sb.append("Deficient");
            } else {
                sb.append("Abundant");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
