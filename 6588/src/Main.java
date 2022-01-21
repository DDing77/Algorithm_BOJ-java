import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Arrays.fill(prime, true);
        for (int i = 2; i <= 100000; i++) {
            if (!prime[i]) continue;
            for (int j = i + i; j <= 100000; j += i) {
                prime[j] = false;
            }
        }
        for(int i=0; i<=100000; i++) {
            if(prime[i]) System.out.println(i);
        }
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.print(sb);
                break;
            }
            boolean check = false;
            for (int i = 2; i <= N / 2; i++) {
                if (prime[i] && prime[N - i]) {
                    sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append('\n');
                    check = true;
                    break;
                }
            }
            if (!check) sb.append("Goldbach's conjecture is wrong.").append('\n');
        }
    }
}
