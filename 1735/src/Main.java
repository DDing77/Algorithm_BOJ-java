import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static void solution(int A_up, int A_down, int B_up, int B_down) {
        int temp_down_gcd = gcd(A_down, B_down);
        int res_down_lcm = (A_down * B_down) / temp_down_gcd;
        A_up *= res_down_lcm / A_down;
        B_up *= res_down_lcm / B_down;

        int res_up = A_up + B_up;
        int res_gcd = gcd(res_down_lcm, res_up);

        int res_A = res_up / res_gcd;
        int res_B = res_down_lcm / res_gcd;

        System.out.println(res_A + " " + res_B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A_up = Integer.parseInt(st.nextToken());
        int A_down = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B_up = Integer.parseInt(st.nextToken());
        int B_down = Integer.parseInt(st.nextToken());

        solution(A_up, A_down, B_up, B_down);
    }
}
