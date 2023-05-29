import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long max = 0;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr =new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        if(N %2 == 1) {
            max = arr[N-1];
            for(int i=0; i<(N-1)/2; i++) {
                max = Math.max(max, arr[i] + arr[N-2-i]);
            }
        } else {
            for(int i=0; i<N/2; i++) max = Math.max(max, arr[i] + arr[N-1-i]);
        }
        System.out.println(max);
    }
}
