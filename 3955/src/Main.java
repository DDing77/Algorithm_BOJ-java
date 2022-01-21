import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static EGResult extendedGcd(int a, int b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }

    static class EGResult {
        long s;
        long t;
        long r;

        public EGResult(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //
            EGResult result = extendedGcd(A, B);
            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                // 초기 해
                // x0 = s * C/D
                // y0 = t * C/D
                long x0 = result.s;
                long y0 = result.t;

                // 일반해 구하기
                // x = x0 + B / D * K
                // y = y0 - A / D * K   (이문제에선 D가 1)

                // k의 범위
                // x < 0
                // x0 + B * k < 0
                // k < -x0 / B

                // 0 < y <= 1e9
                // 0 < y0 - A * k <= 1e9
                // -y0 < -A * k <= 1e9 - y0
                // ( y0 - 1e9 ) / A <= k <  y0 / A

                // (y0 - 1e9) / A <= k < y0 / A
                //                   k < -x0 / B
                long kFromY = (long) Math.ceil((double) y0 / (double) A) - 1; // 이퀄이 없을때 천장함수 - 1
                long kFromX = (long) Math.ceil((double) -x0 / (double) B) - 1;
                long k = Math.min(kFromY, kFromX);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A);
                // 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
                if (kLimitFromY <= k) {
                    System.out.println(y0 - A * k);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
}
