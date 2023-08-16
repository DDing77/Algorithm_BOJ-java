import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int L;
    int[] count;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        int cur = 1;
        count[cur]++;

        res = 0;
        while (count[cur] != M) {

            res++;
            if (count[cur] % 2 == 0) {
                cur -= L;
                if (cur <= 0) {
                    cur = N + cur;
                }
            } else {
                cur += L;
                if (cur > N) {
                    cur = cur % N;
                }
            }

            count[cur]++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
