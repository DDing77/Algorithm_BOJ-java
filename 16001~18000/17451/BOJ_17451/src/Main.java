import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] vArr;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        vArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            vArr[i] = Integer.parseInt(st.nextToken());
        }

        long res = vArr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (vArr[i] >= res) {
                res = vArr[i];
            } else {
                res = (long) vArr[i] * ((res + vArr[i] - 1) / vArr[i]);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
