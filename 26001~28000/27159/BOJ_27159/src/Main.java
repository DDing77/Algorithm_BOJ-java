import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int pre = Integer.parseInt(st.nextToken());
        int cur;
        res = pre;
        for (int i = 1; i < N; i++) {
            cur = Integer.parseInt(st.nextToken());

            if (cur - pre != 1) {
                res += cur;
            }

            pre = cur;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
