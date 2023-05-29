import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -7 -4 -3 -2 0 1 2 5 9 12
public class Main {
    static int T, N, K;
    static int[] arr;

    static void twoPointer(StringBuilder sb) {
        Arrays.sort(arr);

        int L = 0;
        int R = N - 1;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (Math.abs(K - sum) == min) cnt++;
            else if (Math.abs(K - sum) < min) {
                cnt = 1;
                min = Math.abs(K - sum);
            }
            if (sum >= K) R--;
            else L++;
        }
        sb.append(cnt).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            twoPointer(sb);
        }
        System.out.print(sb);
    }
}
