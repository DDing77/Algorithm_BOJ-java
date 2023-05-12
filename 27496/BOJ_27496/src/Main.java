import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int L;
    private int[] alcohol;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        alcohol = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            alcohol[i] += Integer.parseInt(st.nextToken());
        }

        res = 0;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i > L) {
                sum -= alcohol[i - L];
            }

            sum += alcohol[i];

            if (129 <= sum && sum <= 138) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
