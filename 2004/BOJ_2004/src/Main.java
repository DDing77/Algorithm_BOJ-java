import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static long count5(int num) {
        long temp = 0;
        while (num >= 5) {
            temp += num / 5;
            num /= 5;
        }
        return temp;
    }

    static long count2(int num) {
        long temp = 0;
        while (num >= 2) {
            temp += num / 2;
            num /= 2;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long cnt2 = count2(N) - count2(M) - count2(N - M);
        long cnt5 = count5(N) - count5(M) - count5(N - M);

        System.out.println(Math.min(cnt2, cnt5));
    }
}