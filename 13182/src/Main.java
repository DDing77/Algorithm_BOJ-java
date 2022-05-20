import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int R, G, B, K;

    static long powerModular ( long power, long x) {
        long res = 1;
        while(power > 0) {
            if (power % 2 != 0) res = res * x % 1000000007;
            x = x * x % 1000000007;
            power /= 2;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T -- >0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            long ans = K;
            long temp;
            temp = powerModular(K, B) * powerModular(1000000007 - K -1, 1 + B) % 1000000007;
            temp = (1 - temp + 1000000007) % 1000000007;
            temp = temp * R % 1000000007;

            ans = ( ans + temp) % 1000000007;
            temp = G * powerModular(1000000007-2, B) % 1000000007;
            temp = temp * K % 1000000007;

            ans = (ans + temp) % 1000000007;
            System.out.println(ans);
        }
    }
}
