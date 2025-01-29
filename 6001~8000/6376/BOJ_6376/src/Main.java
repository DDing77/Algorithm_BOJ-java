import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double[] factorial;

    private void solution() throws IOException {

        sb.append("n e").append("\n")
                .append("- -----------").append("\n")
                .append(0).append(" ").append(1).append("\n");

        factorial = new double[10];
        factorial[0] = 1;
        double e = factorial[0];
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
            e += 1 / factorial[i];

            sb.append(i).append(" ");
            if (i == 1) {
                sb.append(2).append("\n");
            } else if (i == 2) {
                sb.append(2.5).append("\n");
            } else {
                sb.append(String.format("%.9f", e)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
