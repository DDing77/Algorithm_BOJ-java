import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] A;
    static int N;
    static long ans;

    static long GCD(long a, long b){
        if( b== 0) return a;
        return GCD(b, a%b);
    }

    static long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new boolean[1000001];
        A[0] = true;
        A[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (A[i]) continue;

            for (int j = 2 * i; j <= 1000000; j += i) {
                A[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = 1;

        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(st.nextToken());
            if (A[index] == false) {
                ans = LCM(ans, index);
            }
        }
        if(ans == 1) ans = -1;
        System.out.println(ans);
//        for(int i=0; i<N; i++) {
//            System.out.println(A[i]);
//        }
    }
}
