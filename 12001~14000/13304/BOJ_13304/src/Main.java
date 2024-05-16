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
    private int K;
    private int[] sum;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sum = new int[5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (grade <= 2) {
                sum[0]++;
            } else if (grade <= 4) {
                if (sex == 1) {
                    sum[1]++;
                } else {
                    sum[2]++;
                }
            } else if (grade <= 6) {
                if (sex == 1) {
                    sum[3]++;
                } else {
                    sum[4]++;
                }
            }
        }

        for (int i = 0; i < sum.length; i++) {
            res += (sum[i] + K - 1) / K;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
