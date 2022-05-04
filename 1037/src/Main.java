import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cnt = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= cnt; i++) {
            int now = Integer.parseInt(st.nextToken());

            max = Math.max(max, now);
            min = Math.min(min, now);
        }

        int res = max * min;
        System.out.println(res);
    }
}
