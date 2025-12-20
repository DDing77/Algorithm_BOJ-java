import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int gcd = getGCD(N, M);

        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                sb.append(i).append(" ").append(N/i).append(" ").append(M/i).append("\n");
                int temp = gcd / i;
                if (temp != i) {
                    sb.append(gcd / i).append(" ").append(N/(gcd/i)).append(" ").append(M/(gcd/i)).append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
