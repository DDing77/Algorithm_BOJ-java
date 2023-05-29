import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt = 99;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int a, b ,c;
        if( N< 100) System.out.println(N);
        else {
            for(int i= 100; i<=N; i++) {
                a = i/ 100;
                b = (i/10) %10;
                c = i %10;
                if((a - b) == (b -c)) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
