import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, K;
    private int[] sensors;
    private int[] diff;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensors = new int[N];
        diff = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        for (int i = 1; i < N; i++) {
            diff[i - 1] = sensors[i] - sensors[i - 1];
        }

        Arrays.sort(diff);

        res = 0;
        for (int i = 0; i < N - K; i++) {
            res += diff[i];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}