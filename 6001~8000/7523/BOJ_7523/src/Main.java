import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    int n;
    int m;
    long res;

    private long getSum(int num) {
        return num * (long) (num + 1) / 2;
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            res = getSum(m) - getSum(n - 1);

            sb.append("Scenario #").append(tc).append(":").append("\n");
            sb.append(res).append("\n\n");
        }

        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
