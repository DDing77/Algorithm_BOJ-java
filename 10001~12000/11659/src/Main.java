import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] map;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. N * N 지도 입력 받기
        map = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + map[i];
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int res = dp[y] - dp[x-1];
            sb.append(res).append('\n');
        }
        System.out.println(sb);

//
//
//
//
//        bw.write(sb.toString());
//
//        bw.flush();
//        bw.close();
//        br.close();
    }
}