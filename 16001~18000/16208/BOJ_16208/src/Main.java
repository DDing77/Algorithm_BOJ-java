import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                res += arr[i] * (arr[N - 1] - arr[i]);
                continue;
            }
            res += (arr[N - 1] - arr[i]) * (arr[i] - arr[i - 1]);
        }

        System.out.println(res);
    }
}