import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s;
    static ArrayList<Integer> v;
    static final int MAX = 301;
    static int[] p;
    static int[][][] dp;

    static int solution(int l, int r, int state, int rem) {
        if(rem == 0) return 0;
        if(l > r) return (int) 1e9;

        int ret = dp[l][r][state];

        if(ret != -1) return ret;

        ret = (int) 1e9;

        if(l>0){
            if(r != n) ret = Math.min(ret, solution(l, r+1, 0, rem - 1) +
                    rem*(v.get(r+1) - v.get(l)));
            if(l >0) ret = Math.min(ret, solution(l-1, r, 1, rem -1) +
                    rem*(v.get(l) - v.get(l-1)));
        } else {
            if(r != n) ret = Math.min(ret, solution(1, r+1, 0, rem - 1) +
                    rem *(v.get(r+1) - v.get(r)));
            if( l> 0) ret = Math.min(ret, solution(l-1, r, 1, rem -1) +
                    rem *(v.get(r) - v.get(l-1)));
        }
        return ret;
    }

    static int lowerBound(ArrayList<Integer> p, int target) {
        int begin = 0;
        int end = p.size();

        while(begin < end) {
            int mid = ( begin + end) >> 1;
            if(v.get(mid) >= target) end = mid;
            else begin = mid + 1;
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new ArrayList<>();
        dp = new int[MAX][MAX][2];


        for(int i=0; i<n; i++) {
            v.add(Integer.parseInt(br.readLine()));
        }
        v.add(0);

        Collections.sort(v);
        Arrays.fill(dp, -1);
        int idx = lowerBound(v, 0) - v.get(0);

        for(int i=0; i<=n; i++) {
            Arrays.fill(dp, -1);
            ans = Math.max(ans, i *m - solution(idx, idx, 0 ,i));
        }

        System.out.println(ans);
    }
}
