import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T, N, M;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            res = 0;
            for (int i = N; i <= M; i++) {
                String cur = String.valueOf(i);
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '0') {
                        res++;
                    }
                }
            }
            sb.append(res).append('\n');

        }
        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
