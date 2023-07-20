import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int min;
    static int max;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }

            sb.append(min).append(" ").append(max).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
