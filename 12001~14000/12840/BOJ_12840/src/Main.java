import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int DAY_TOTAL_SECOND = 3_600 * 24;
    static final int DAY_HOUR_SECOND = 3600;
    static final int DAY_MINUTE_SECOND = 60;
    int h;
    int m;
    int s;
    int curTotalSecond;
    int q;
    int T;
    int c;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        curTotalSecond = h * DAY_HOUR_SECOND + m * DAY_MINUTE_SECOND + s;

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());

            if (T == 1) {
                c = Integer.parseInt(st.nextToken());
                curTotalSecond = (curTotalSecond + c) % DAY_TOTAL_SECOND;
            } else if (T == 2) {
                c = Integer.parseInt(st.nextToken());
                curTotalSecond -= c;

                while (curTotalSecond < 0) {
                    curTotalSecond += DAY_TOTAL_SECOND;
                }
            } else if (T == 3) {
                sb.append(curTotalSecond / DAY_HOUR_SECOND)
                        .append(" ").append((curTotalSecond / 60) % 60)
                        .append(" ").append(curTotalSecond % 60)
                        .append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
