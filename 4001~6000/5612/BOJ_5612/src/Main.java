import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        res = M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = M + Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if (M < 0) {
                System.out.println(0);
                return;
            }

            res = Math.max(res, M);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
