import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Tc;
    static int a, b;
    static long lcm;

    static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < Tc; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int gcd = getGcd(a, b);
            sb.append((a / gcd) * b).append('\n');
        }
        System.out.print(sb);
    }
}