import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static long N;
    static ArrayList<Long> res;
    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

    static long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            long res = a % b;
            a = b;
            b = res;
        }
        return a;
    }

    static long mul(long x, long n, long c) {
        return BigInteger.valueOf(x)
                .multiply(BigInteger.valueOf(x))
                .add(BigInteger.valueOf(c))
                .remainder(BigInteger.valueOf(n)).longValue();
    }

    static void pr(long n) {
        if (n == 1) return;
        if (n % 2 == 0) {
            res.add(2l);
            pr(n / 2);
            return;
        }

        if (BigInteger.valueOf(n).isProbablePrime(10)) {
            res.add(n);
            return;
        }

        long x = 0;
        long y = 0;
        long c = 0;
        long v = n;

        do {
            if (v == n) {
                x = y = (long) (Math.random() * (n - 2)) + 2;
                c = (long) (Math.random() * 20) + 1;
            }
            x = mul(x, n, c);
            y = mul(mul(y, n, c), n, c);
            v = gcd(Math.abs(x - y), n);
        } while (v == 1);
        pr(v);
        pr(n / v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        res = new ArrayList<>();
        if (N == 1) {
            System.out.println(1);
            return;
        }
        pr(N);

        Collections.sort(res);

        if (res.size() > 0) {
            long pre = res.get(0);
            int cnt = 0;
            int ans = 1;
            for (long i : res) {
                if (i == pre) cnt++;
                else {
                    ans *= (cnt + 1);
                    cnt = 1;
                    pre = i;
                }
            }
            ans *= (cnt + 1);
            System.out.println(ans);
        }
    }
}
