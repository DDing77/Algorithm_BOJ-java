import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, A, B;

    static int GCD(int a, int b) {
        if( b == 0) return a;
        return GCD(b, a%b);
    }

    static int LCM(int gcd, int a, int b) {
        int res = a * b / gcd;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int gcd = GCD(A,B);
            sb.append(LCM(gcd, A, B)).append('\n');
        }
        System.out.print(sb);
    }
}
