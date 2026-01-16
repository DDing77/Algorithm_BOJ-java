import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int C;
    private int W;
    private int[] woods;
    private long resMax;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        woods = new int[N];
        int maxWoodLength = 0;
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(br.readLine());
            maxWoodLength = Math.max(maxWoodLength, woods[i]);
        }

        resMax = Integer.MIN_VALUE;
        for (int i = 1; i <= maxWoodLength; i++) {
            long sum = 0L;
            for (int j = 0; j < N; j++) {
                long cnt;
                if (woods[j] >= i) {
                    cnt = woods[j] / i;
                    if (woods[j] % i == 0) {
                        cnt--;
                    }
                    long price = (long) (woods[j] / i) * W * i - cnt * C;
                    if (price > 0) {
                        sum += price;
                    }
                }
            }
            resMax = Math.max(resMax, sum);
        }

        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
