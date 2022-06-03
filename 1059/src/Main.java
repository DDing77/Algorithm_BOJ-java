import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        arr = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        n = Integer.parseInt(br.readLine());

        int left = 0, right = 987654321;
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                right = Math.min(right, arr[i]);
            } else if (arr[i] < n) {
                left = Math.max(left, arr[i]);
            } else {
                flag = true;
                break;
            }
        }
        int L = (n - left - 1);
        int R = (right - n - 1);
        int ans = L + R + (L * R);

        if (flag)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
