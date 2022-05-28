import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int s, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (k % 2 == 0) {
                s %= (k + 1);
                if (s == k) sb.append(k).append('\n');
                else if (s % 2 > 0) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else {
                if (s % 2 > 0) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.print(sb);
    }
}
