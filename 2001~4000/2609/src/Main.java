import java.io.*;
import java.util.StringTokenizer;

public class Main { // BOJ_2609
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int gcd = gcd(A, B);
        int lcm = (A * B) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int A, int B) {
        if (B == 0) return A;
        else return gcd(B, A % B);
    }
}
