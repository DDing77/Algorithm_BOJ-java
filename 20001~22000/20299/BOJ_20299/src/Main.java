import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int L;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            boolean flag = true;
            int[] rating = new int[3];
            for (int j = 0; j < 3; j++) {
                rating[j] = Integer.parseInt(st.nextToken());
                if (rating[j] < L) {
                    flag = false;
                    continue;
                }
                sum += rating[j];
            }

            if (sum >= K && flag) {
                res++;
                for (int j = 0; j < rating.length; j++) {
                    sb.append(rating[j]).append(" ");
                }
            }
        }
        sb.insert(0, res + "\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
