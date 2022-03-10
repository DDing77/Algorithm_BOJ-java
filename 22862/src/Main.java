import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int odd = 0;
    static int even = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        while(left <= right && right <N) {
            if(odd <= K) {
                if(arr[right] %2 ==0) even++;
                else if(arr[right] %2 == 1) odd++;
                max = Math.max(max, even);
                right++;
            }
            else {
                if(arr[left] %2 ==0) even--;
                else if (arr[left] %2 == 1) odd--;
                left++;
            }
        }
        System.out.println(max);
    }
}
