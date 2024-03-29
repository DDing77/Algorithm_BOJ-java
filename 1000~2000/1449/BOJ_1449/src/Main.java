import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int[] leak;

    public static int getRes() {
        int res = 1;
        int start = leak[0];

        for (int i = 1; i < N; i++) {
            if (leak[i] - start >= L) {
                res++;
                start = leak[i];
            }
        }

        return res;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        leak = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);

        System.out.println(getRes());
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
