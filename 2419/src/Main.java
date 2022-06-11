import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int x, res;
    static int[][][] dp;
    static ArrayList<Integer> v;

    static void dpFill() {
        for(int i=0; i<333; i++) {
            for(int j=0; j<333; j++) {
                for(int k=0; k<2; k++) dp[i][j][k] = -1;
            }
        }
    }

    static int lower_bound(ArrayList<Integer> array, int key)
    {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.size();
        int mid;

        // Till high does not crosses low
        while (low < high) {

            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array.get(mid)) {
                high = mid;
            }

            // If key is greater than array[mid],
            // then find in right subarray
            else {

                low = mid + 1;
            }
        }

        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.size() && array.get(low) < key) {
            low++;
        }

        // Returning the lower_bound index
        return low;
    }

    static int func(int l, int r, int state, int rem) {
        if (rem == 0) return 0;
        if (l >r) return (int)1e9;
        if(dp[l][r][state] != -1) return dp[l][r][state];
        dp[l][r][state] = (int)1e9;
        if( state > 0) {
            if( r != N) dp[l][r][state] = Math.min(dp[l][r][state],
                    func(l , r+1, 0, rem - 1) + rem * (v.get(r+1) - v.get(l)));
            if( l > 0) dp[l][r][state] = Math.min(dp[l][r][state],
                    func(l -1 , r, 1, rem - 1) + rem * (v.get(l) - v.get(l - 1)));
        } else {
            if( r != N) dp[l][r][state] = Math.min(dp[l][r][state],
                    func(l , r+1, 0, rem - 1) + rem * (v.get(r+1) - v.get(r)));
            if( l > 0) dp[l][r][state] = Math.min(dp[l][r][state],
                    func(l -1 , r, 1, rem - 1) + rem * (v.get(r) - v.get(l - 1)));
        }
        return dp[l][r][state];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[333][333][2];
        v = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            v.add(input);
        }
        v.add(0);

        Collections.sort(v);
        dpFill();

        int idx = lower_bound(v, 0) - v.get(0);
        System.out.println(idx);

        res = 0;
        for(int i=0; i<=N; i++) {
            dpFill();
            res = Math.max(res, i *M - func(idx, idx, 0 , i));
        }

        System.out.println(res);
    }
}
