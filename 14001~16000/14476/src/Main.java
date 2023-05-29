import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, lgcd, rgcd;

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    static void solution(){
        lgcd[0] = arr[0];
        rgcd[N- 1] = arr[N- 1];
        for(int i=1; i<N; i++) {
            lgcd[i] = gcd(lgcd[i-1], arr[i]);
        }
        for(int i=N-2; i>=0; i--) {
            rgcd[i] = gcd(rgcd[i+1], arr[i]);
        }

        int delete = -1;
        int max = 0;
        for( int i =1; i<N; i++) {
            int res = gcd(lgcd[i-1], rgcd[i+1]);
            if( res > max && arr[i] % res != 0) {
                delete = arr[i];
                max = res;
            }
        }
        if(delete == -1) System.out.println(-1);
        else {
            System.out.print(max);
            System.out.println(" " +delete );
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lgcd = new int[N];
        rgcd = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
