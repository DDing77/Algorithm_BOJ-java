import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int m;
    int M;
    int T;
    int R;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int cur = m;
        res = 0;
        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        while (N > 0) {
            res++;
            if (cur + T <= M) {
                N--;
                cur += T;
            } else if (cur - R > m) {
                cur -= R;
            } else {
                cur = m;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
