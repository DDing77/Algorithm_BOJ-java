import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int A;
    private int B;
    private int C;
    private int D;
    private int[] toppings;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        toppings = new int[N];
        for (int i = 0; i < N; i++) {
            toppings[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toppings);

        res = C / A;
        for (int i = N - 1; i >= 0; i--) {
            C += toppings[i];
            if (res > C / ((N - i) * B + A)) {
                break;
            }
            res = C / ((N - i) * B + A);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
