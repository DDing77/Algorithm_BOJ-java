import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int l, v1, v2, t, s;
    static int range;
    static int measure1, measure2;
    static int min, max;
    static int cnt;

    static void getCnt() {
        while (measure1 > range && range > 0) {
            cnt++;
            max = l / (s * cnt);
            measure2 = Math.min(measure1, (max - min + t) / t);
            range -= measure1 - measure2;
            range *= 2;
            measure1 = measure2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            cnt = 0;
            range = 1;

            measure1 = ((v2 - v1) + (t - 1)) / t;
            min = v2 - (measure1 * t);

            getCnt();

            if (range <= 0) sb.append("impossible").append('\n');
            else sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
