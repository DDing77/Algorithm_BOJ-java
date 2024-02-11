import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MOD = 14_579;
    int a;
    int b;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cur = a * (a + 1) / 2;

        res = cur % MOD;

        for (int i = a + 1; i <= b; i++) {
            cur += i;
            res *= cur;
            res %= MOD;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
