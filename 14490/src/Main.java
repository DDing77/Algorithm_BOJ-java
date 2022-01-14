import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] str = br.readLine().split(":");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        System.out.println(n / gcd(n, m) + ":" + m / gcd(n, m));
    }
}