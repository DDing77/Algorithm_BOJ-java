import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int minEndTime;
    private int maxStartTime;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        minEndTime = Integer.MAX_VALUE;
        maxStartTime = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            maxStartTime = Math.max(maxStartTime, start);
            minEndTime = Math.min(minEndTime, end);
        }

        System.out.println(Math.max(0, maxStartTime - minEndTime));

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
