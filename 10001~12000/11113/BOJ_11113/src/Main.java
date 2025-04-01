import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private Coordination[] coordinations;
    private int[] idxs;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        coordinations = new Coordination[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordinations[i] = new Coordination(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            int p = Integer.parseInt(br.readLine());
            double sum = 0.;

            idxs = new int[p];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < p; i++) {
                idxs[i] = Integer.parseInt(st.nextToken());
                if (i != 0) {
                    sum += Math.sqrt(
                            Math.pow((coordinations[idxs[i - 1]].x - coordinations[idxs[i]].x), 2)
                                    + Math.pow((coordinations[idxs[i - 1]].y - coordinations[idxs[i]].y), 2));
                }
            }
            sb.append((int)Math.round(sum)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Coordination {

        double x;
        double y;

        public Coordination(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
