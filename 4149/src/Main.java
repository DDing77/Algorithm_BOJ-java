import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         n = Long.parseLong(br.readLine());

         while(n > 1) {
             for(int i=2; i<=n; i++) {
                 while(n % i == 0) {
                     sb.append(i).append('\n');
                     n /= i;
                 }
             }
         }
         System.out.print(sb);
    }
}
