import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long D, P, Q;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        res = D / (P * Q) * (P * Q);

        if (res > 0) res -= P * Q;
        D -= res;
        if (P < Q) {
            long temp = P;
            P = Q;
            Q = temp;
        }
        long min = (long) 2e9;
        for (long i = 0; i * P <= D + P; i++) min = Math.min(min, i * P + ((D - P * i + Q - 1) / Q) * Q);
        res += min;
        System.out.println(res);
    }
}
