import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    static long sum =0, cnt =0;

    static long GCD(int a, int b){
        if( b == 0) return a;
        return GCD(b , a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X= Integer.parseInt(br.readLine());
        for( int i=0; i<N; i++) {
            if(GCD(arr[i], X) == 1){
                sum += arr[i];
                cnt++;
            }
        }
       ;
        System.out.printf("%.6f", (double)sum / cnt);
    }
}
