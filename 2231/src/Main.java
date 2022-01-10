import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int length = str.length();
        int ans = 0;

        for(int i = N - (length*9); i<N; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number%10;
                number /= 10;
            }

            if( sum + i == N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
