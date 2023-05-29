import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] cnt;
    static HashMap<Integer, Integer> map;
    static int twoPointer() {
        int max = Integer.MIN_VALUE;
        int L = 0;
        int R = 0;
        while(L < N && L <= R && R<N){
            if(cnt[arr[R]] <K) {
                cnt[arr[R]]++;
                R++;
            } else {
                cnt[arr[L]]--;
                L++;
            }
            max = Math.max(max, R-L);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(twoPointer());
    }
}
// 2 3 4 4 5 5 5 6 7