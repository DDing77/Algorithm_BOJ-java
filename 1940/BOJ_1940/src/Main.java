import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int l = 0, r = arr.length - 1;
        int cnt = 0;
        while (l < r) {
            if (arr[l] + arr[r] == M) {
                l++;
                r--;
                cnt++;
            } else {
                if (arr[l] + arr[r] > M) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        System.out.println(cnt);
    }
}