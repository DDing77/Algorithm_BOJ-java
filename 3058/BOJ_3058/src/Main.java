import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int sum;
    static int min;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sum = 0;
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            int cur;
            while (st.hasMoreTokens()) {
                cur = Integer.parseInt(st.nextToken());
                if (cur % 2 == 0) {
                    sum += cur;
                    min = Math.min(min, cur);
                }
            }

            sb.append(sum + " " + min).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
