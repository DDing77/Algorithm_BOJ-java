import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int hour;
    private int min;
    private int remainTime;
    private int res;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String timeStamp = st.nextToken();
            hour = Integer.parseInt(timeStamp.split(":")[0]);
            min = Integer.parseInt(timeStamp.split(":")[1]);
            remainTime = Integer.parseInt(st.nextToken());

            res = 0;
            while (remainTime > 0) {
                if (remainTime > 300 && (22 <= hour || hour < 3)) {
                    while (hour != 8) {
                        hour = (hour + 1) % 24;
                        remainTime -= 60;
                    }
                    remainTime += min;
                    min = 0;
                    res += 5000;
                    continue;
                }

                hour = (hour + 1) % 24;
                remainTime -= 60;
                res += 1000;
            }
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
