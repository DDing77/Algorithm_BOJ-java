import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final double[] cost = {350.34, 230.90, 190.55, 125.30, 180.90};
    static int T;
    static double res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            res = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                res += Double.parseDouble(st.nextToken()) * cost[i];
            }

            sb.append("$").append(String.format("%.2f", res)).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
