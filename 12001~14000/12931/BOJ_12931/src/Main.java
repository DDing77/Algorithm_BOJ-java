import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] num;
    static int res;

    /**
     * @return 0 -> zero
     * 1 -> odd
     * 2 -> even
     */
    public static int check() {
        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            if (num[i] % 2 == 1) {
                num[i]--;
                res++;
                return 1;
            }
            if (num[i] == 0) {
                zeroCnt++;
            }
        }

        if (zeroCnt == N) {
            return 0;
        }

        return 2;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        while (true) {
            int type = check();

            if (type == 1) {
                continue;
            }

            if (type == 2) {
                res++;
                for (int i = 0; i < N; i++) {
                    num[i] /= 2;
                }
            }

            if (type == 0) {
                break;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
