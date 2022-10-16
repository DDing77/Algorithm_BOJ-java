import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = N - 1; i >= 1; i--) {
            if (arr[i] <= arr[i - 1]) {
                int diff = arr[i - 1] - arr[i] + 1;
                arr[i - 1] -= diff;
                res += diff;
            }
        }

        System.out.println(res);
    }
}
