import java.io.*;
import java.util.*;

public class Main {
    static int max = 0, cnt = 0, idx, N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= K) {
                max = arr[i];
                idx = i;
            }
        }
        int sum = 0;
        while (sum <= K) {
            if(K - sum >= arr[idx]) {
                sum += arr[idx];
                cnt++;
            }
            else {
                idx--;
                if(idx < 0) break;
            }
        }
        System.out.println(cnt);
    }
}
