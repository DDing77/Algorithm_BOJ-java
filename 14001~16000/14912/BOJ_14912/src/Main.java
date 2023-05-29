import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, d;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        cnt = new int[10];

        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                cnt[temp % 10]++;
                temp /= 10;
            }
        }

        System.out.println(cnt[d]);
    }
}
