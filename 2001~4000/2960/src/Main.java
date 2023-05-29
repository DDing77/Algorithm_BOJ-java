import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        prime = new boolean[N + 1];
        int res = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if(prime[j] == false) {
                    prime[j] = true;
                    cnt++;
                }
                if(cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}