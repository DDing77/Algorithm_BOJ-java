import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int a;
    int b;
    int c;
    int d;
    int res;

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 & c == 0 && d == 0) {
                break;
            }

            res = 0;
            while (!(a == b && b == c && c == d)) {
                res++;

                int nextA = Math.abs(a - b);
                int nextB = Math.abs(b - c);
                int nextC = Math.abs(c - d);
                int nextD = Math.abs(d - a);

                a = nextA;
                b = nextB;
                c = nextC;
                d = nextD;
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
