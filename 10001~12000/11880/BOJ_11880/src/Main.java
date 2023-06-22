import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int testCase;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            long sum = 0;
            long max = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                int cur = Integer.parseInt(st.nextToken());
                sum += cur;
                max = Math.max(max, cur);
            }

            sb.append(max * max + (sum - max) * (sum - max)).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
