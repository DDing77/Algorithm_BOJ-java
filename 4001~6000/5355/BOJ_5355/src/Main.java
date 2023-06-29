import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static double res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            res = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                String op = st.nextToken();
                if (op.equals("@")) {
                    res *= 3;
                }
                if (op.equals("%")) {
                    res += 5;
                }
                if (op.equals("#")) {
                    res -= 7;
                }
            }

            sb.append(String.format("%.2f", res)).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
