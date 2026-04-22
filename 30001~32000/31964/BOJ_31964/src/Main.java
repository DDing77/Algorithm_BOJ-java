import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] posArr;
    private int[] timeArr;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        posArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            posArr[i] = Integer.parseInt(st.nextToken());
        }

        timeArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            timeArr[i] = Integer.parseInt(st.nextToken());
        }

        res = Math.max(posArr[N - 1], timeArr[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            int dist = posArr[i + 1] - posArr[i];
            res += dist;
            if (res < timeArr[i]) {
                res = timeArr[i];
            }
        }
        res += posArr[0];
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
