import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 3; j < N; j++) {
                int L = i + 1;
                int R = j - 1;
                while (L < R) {
                    int temp = arr[L] + arr[R] - (arr[i] + arr[j]);
                    if (res > Math.abs(temp)) res = Math.abs(temp);
                    if (temp < 0) L++;
                    else R--;
                }
            }
        }
        System.out.println(res);
    }
}
