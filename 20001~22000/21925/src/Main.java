import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans =0;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for( int i =0, j; i<N;){
            boolean found = false;
            for(j = i+1; j<N; j+=2) {
                int L = i, R = j;
                boolean isPalindrome = true;
                while(L <R) {
                    if(arr[L] != arr[R]) {
                        isPalindrome = false;
                        break;
                    }
                    L++;
                    R--;
                }
                if(isPalindrome) {
                    ans++;
                    found= true;
                    break;
                }
            }
            if(!found) {
                ans = -1;
                break;
            }
            i = j+1;
        }
        System.out.println(ans);
    }
}
