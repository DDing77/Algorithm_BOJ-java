import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, x;
    static int[] arr;

    static void twoPointer() {
        int L = 0;
        int R = arr.length - 1;
        int cnt = 0;
        while (L < R) {
            if (arr[L] + arr[R] == x) {
                cnt++;
                L++;
                R--;
            } else if(arr[L] + arr[R] > x) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        twoPointer();
    }
}
