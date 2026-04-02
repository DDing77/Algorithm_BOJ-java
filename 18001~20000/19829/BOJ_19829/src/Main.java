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
    private int[] colors;
    private int resMax;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        colors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        while (right < N) {
            if (colors[right - 1] == colors[right]) {
                int cnt = right - left;
                resMax = Math.max(resMax, cnt);
                left = right;
                right++;
            } else {
                right++;
            }
        }

        resMax = Math.max(resMax, right - left);

        System.out.println(resMax);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
