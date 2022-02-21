import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp  =new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = arr[1];
        for(int i=2; i<=N; i++) {
            dp[i] = arr[i];
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}

