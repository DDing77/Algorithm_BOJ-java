import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int R;
    static int X;
    static int[] arr;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[15];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < (1 << N); i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            int sum = 0;
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) >= 1) {
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                    sum += arr[j];
                    cnt++;
                }
            }

            if (cnt >= 2 && sum >= L && sum <= R && max - min >= X) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
