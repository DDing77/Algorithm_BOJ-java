import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    long X;
    long Y;
    long W;
    long S;
    long res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());

        if (W * 2 < S) {
            res = (X + Y) * W;
        } else {
            long min = Math.min(X, Y);
            res = min * S;
            X -= min;
            Y -= min;
            if (X == 0) {
                if (Y % 2 == 0) {
                    res += Math.min(Y * W, (Y / 2) * S * 2);
                } else {
                    res += Math.min(Y * W, (Y / 2) * S * 2 + (Y % 2) * W);
                }
            } else {
                if (X % 2 == 0) {
                    res += Math.min(X * W, (X / 2) * S * 2);
                } else {
                    res += Math.min(X * W, (X / 2) * S * 2 + (X % 2) * W);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
