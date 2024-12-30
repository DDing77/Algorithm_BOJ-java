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
    private double D;
    private double v;
    private double f;
    private double c;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Double.parseDouble(st.nextToken());

            int res = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                v = Double.parseDouble(st.nextToken());
                f = Double.parseDouble(st.nextToken());
                c = Double.parseDouble(st.nextToken());

                if (D <= v * (f / c)) {
                    res++;
                }
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
