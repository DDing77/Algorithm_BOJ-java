import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int time;
    private double[][] transition = new double[4][4];

    private void solution() throws IOException {

        time = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = st.nextToken().charAt(0) - 'A';
            int to = st.nextToken().charAt(0) - 'A';
            double p = Double.parseDouble(st.nextToken());

            transition[from][to] = p;
        }

        double[] current = new double[4];
        double[] next = new double[4];

        Arrays.fill(current, 0.25);

        for (int t = 0; t < time; t++) {

            Arrays.fill(next, 0.0);

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    next[j] += current[i] * transition[i][j];
                }
            }

            System.arraycopy(next, 0, current, 0, 4);
        }

        for (int i = 0; i < 4; i++) {
            sb.append(String.format("%.2f\n", current[i] * 100));
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}