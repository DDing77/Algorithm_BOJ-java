import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static ArrayList<Long> res;

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long pr(long N) {
        if (N % 2 == 0) return 2;
        BigInteger temp1 = new BigInteger(String.valueOf(N));
        if (temp1.isProbablePrime(1)) return N;

        long x = (long) Math.random() % (N - 2) + 2;
        long c = (long) Math.random() % 10 + 1;
        long y = x;
        long g = 1;

        while (g == 1) {
            x = (x * x % N + c) % N;
            y = (y * y % N + c) % N;
            y = (y * y % N + c) % N;
            g = gcd(Math.abs(x - y), N);
            if (g == N) return pr(N);
        }
        BigInteger temp2 = new BigInteger(String.valueOf(g));
        if (temp2.isProbablePrime(1)) return g;
        else return pr(g);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Long.parseLong(br.readLine());
        res = new ArrayList<>();

        while (N > 1) {
            long prime = pr(N);
            res.add(prime);
            N /= prime;
        }

        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) sb.append(res.get(i)).append('\n');

        System.out.print(sb);
    }
}
