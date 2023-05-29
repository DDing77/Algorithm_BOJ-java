import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[1001][10001];
        int ans = 0;
        for(int i = 0; i < n; i ++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < line.length; j++){
                //dp의 0행, 0열 -> 모두 '0'으로 만들어주기 위해 dp[i+1][j+1] 로 해줌
                dp[i + 1][j + 1] = line[j] - '0';
                if(dp[i + 1][j + 1] != 0){
                    int temp = Math.min(dp[i][j], dp[i][j + 1]);
                    dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                }
            }
        }
        bw.write((ans * ans) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}