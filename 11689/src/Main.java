import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long euler = N;
        for(long i=2; i*i <=N; i++) {
            if(N % i == 0) euler = euler/i * (i-1);
            while(N % i == 0) N /= i;
        }
        if(N != 1) {
            euler = euler/N *(N-1);
        }
        System.out.println(euler);
    }
}
