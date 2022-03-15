import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    static void twoPointer() {
        int L = 0;
        int R = N - 1;
        int minLeft = 0;
        int minRight = 0;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (Math.abs(sum) < min) {
                minLeft = L;
                minRight = R;
                min = Math.abs(sum);
            }
            if (sum >= 0) R--;
            else L++;
        }
        System.out.println(arr[minLeft] +" "+ arr[minRight]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        twoPointer();
    }
}
