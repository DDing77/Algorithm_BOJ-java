import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int res;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            res = 1;
            while (N >= sum) {
                res++;
                sum *= 4;
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
// 1 2 4 6
// 1 2 3 5
// 2 3 4 6
// 3 4 5 1
// 2 4 5 6
// 1 3 5 6