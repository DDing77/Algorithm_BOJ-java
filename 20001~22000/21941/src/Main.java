import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int M;

    //    static String S;
    static class STR {
        String A;
        int X;

        public STR(String A, int X) {
            this.A = A;
            this.X = X;
        }
    }
    static STR[] str;
    static void getDp(String S) {
        int start =0, end;
        for(int i=0; i<=S.length(); i++) {
            end = i;
            dp[i]=i;
            String newS = S.substring(start,end);
            for(int j=0; j<M;j++){
                if(str[j].A == newS) {
                    dp[i] = str[j].X;
                }
                continue;
            }
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String S = br.readLine();
        dp = new int[S.length()+1];
        M = Integer.parseInt(br.readLine());
        str = new STR[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = new STR(st.nextToken(),Integer.parseInt(st.nextToken()));
        }
    }
}
