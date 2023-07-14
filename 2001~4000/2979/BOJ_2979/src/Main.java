import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int A;
    static int B;
    static int C;
    static int[] cnt;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cnt = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                cnt[j]++;
            }
        }

        res = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 1) {
                res += (A * cnt[i]);
            } else if (cnt[i] == 2) {
                res += (B * cnt[i]);
            } else if (cnt[i] == 3) {
                res += (C * cnt[i]);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
