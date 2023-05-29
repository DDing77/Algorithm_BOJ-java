import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, H, W, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t= 0; t<T; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int floor;
            int number;
            if( N % H == 0 ) {
                number = N / H;
            }
            else {
                number = (N / H) + 1;
            }
            if(N % H == 0 ) {
                floor = H*100;
            }
            else {
                floor = N %H*100;
            }

            int res = floor + number;
            System.out.println(res);
        }
    }
}
