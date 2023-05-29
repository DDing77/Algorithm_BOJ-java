import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int M, N, x, y;
    static int res;

    public static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            res = -1;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcd = M * (N / getGCD(M, N));
            int year = x;

            while (true) {
                if (year > lcd) {
                    sb.append(res).append('\n');
                    break;
                }

                int n = year % N == 0 ? N : year % N;
                if (n == y) {
                    sb.append(year).append('\n');
                    break;
                }

                year += M;
            }
        }
        System.out.print(sb);
    }
}
