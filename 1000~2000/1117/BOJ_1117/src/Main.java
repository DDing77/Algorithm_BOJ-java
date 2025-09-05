import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long W;
    private long H;
    private long f;
    private long c;
    private long x1;
    private long y1;
    private long x2;
    private long y2;
    private long res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());
        f = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken()) + 1;
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        long line = f;
        if (f > W / 2) {
            line = W - f;
        }

        long totalArea = W * H;

        if (line <= x1) {
            res = totalArea - (x2 - x1) * (y2 - y1) * c;
        } else if (line > x2) {
            res = totalArea - (x2 - x1) * (y2 - y1) * 2 * c;
        } else {
            res = totalArea - (line - x1) * (y2 - y1) * 2 * c - (x2 - line) * (y2 - y1) * c;

        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
