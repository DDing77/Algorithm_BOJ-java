import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double M;
    private double A;
    private double B;

    private void solution() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Double.parseDouble(st.nextToken());
            A = Double.parseDouble(st.nextToken());
            B = Double.parseDouble(st.nextToken());

            if (M == 0 && A == 0 && B == 0) {
                break;
            }

            double result = Double.parseDouble(
                    String.format("%.0f", (((M / A) - (M / B)) * 3600)));

            int hour = (int) (result / 3600);
            int min = (int) ((result / 60) % 60);
            int sec = (int) (result % 60);

            sb.append(String.format("%d:%02d:%02d", hour, min, sec)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
