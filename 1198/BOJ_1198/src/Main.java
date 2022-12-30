import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] x, y;
    static double res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        x = new int[N];
        y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    res = Math.max(res, Math.abs(x[i] * y[j] + x[j] * y[k] + x[k] * y[i]
                            - x[j] * y[i] - x[k] * y[j] - x[i] * y[k]));
                }
            }
        }
        System.out.println(res / 2);
    }
}
