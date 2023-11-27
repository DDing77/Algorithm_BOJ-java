import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int gcd;
    int lcm;
    int resA;
    int resB;

    public long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        gcd = Integer.parseInt(st.nextToken());
        lcm = Integer.parseInt(st.nextToken());

        long mul = (long) gcd * lcm;
        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0) {
                if (getGCD(i, mul / i) == gcd) {
                    resA = i;
                    resB = (int) (mul / i);
                }
            }
        }

        System.out.println(resA + " " + resB);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
