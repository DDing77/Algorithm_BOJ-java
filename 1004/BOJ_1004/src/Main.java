import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int s1, s2, e1, e2;
    static int res;

    static void calculator(int x, int y, int r) {
        int cnt = 0;
        if (Math.abs(x - s1) * Math.abs(x - s1) + Math.abs(y - s2) * Math.abs(y - s2) <= r * r) {
            res++;
            cnt++;
        }
        if (Math.abs(x - e1) * Math.abs(x - e1) + Math.abs(y - e2) * Math.abs(y - e2) <= r * r) {
            res++;
            cnt++;
        }
        if(cnt == 2) res -= 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());
            e1 = Integer.parseInt(st.nextToken());
            e2 = Integer.parseInt(st.nextToken());

            N = Integer.parseInt(br.readLine());

            res = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                calculator(x, y, r);
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
