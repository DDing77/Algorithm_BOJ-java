import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] x;
    long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        x = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        res = 0L;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                res += Math.abs(x[i] - x[j]);
            }
        }

        System.out.println(res * 2);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
