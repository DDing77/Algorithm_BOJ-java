import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        p = new int[N];


        int res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            res ^= p[i];
        }

        if (res == 0) {
            System.out.println(0);
        } else {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                res = 0;

                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    res ^= p[j];
                }

                for (int j = 0; j < p[i]; j++) {
                    int temp = res;

                    if ((temp ^ j) == 0) cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
