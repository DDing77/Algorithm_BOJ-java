import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean determine(int target_idx){
        int target = arr[target_idx];
        int L = 0, R = arr.length-1;
        while(L<R) {
            if( L == target_idx) L++;
            else if( R== target_idx) R--;
            else {
                if(arr[L] + arr[R] == target) return true;
                if(arr[L] + arr[R] > target) R--;
                else L++;
            }
        }
        return false;
    }
    static void twoPointer() {
        int ans =0;
        for(int i=0; i<arr.length; i++) {
            if(determine(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        twoPointer();
    }
}
