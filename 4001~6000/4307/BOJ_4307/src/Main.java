import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int L;
    private int resMin;
    private int resMax;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            resMin = 0;
            resMax = 0;
            for (int i = 0; i < N; i++) {
                int ant = Integer.parseInt(br.readLine());
                int temp = Math.min(ant, L - ant);
                resMin = Math.max(temp, resMin);
                resMax = Math.max(ant, resMax);
                resMax = Math.max(L - ant, resMax);
            }
            sb.append(resMin).append(" ").append(resMax).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
