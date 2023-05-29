import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            double l;

            if (a == 0 && b == 0 && c == 0) break;
            sb.append("Triangle #" + tc++).append('\n');
            if (a == -1) {
                l = Math.sqrt(c * c - b * b);
                if (l > 0) sb.append("a = " + String.format("%.3f", l)).append('\n');
                else sb.append("Impossible.").append('\n');
                sb.append('\n');
            }
            if (b == -1) {
                l = Math.sqrt(c * c - a * a);
                if (l > 0) sb.append("b = " + String.format("%.3f", l)).append('\n');
                else sb.append("Impossible.").append('\n');
                sb.append('\n');
            }
            if (c == -1) {
                l = Math.sqrt(a * a + b * b);
                if (l > 0) sb.append("c = " + String.format("%.3f", l)).append('\n');
                else sb.append("Impossible.").append('\n');
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
