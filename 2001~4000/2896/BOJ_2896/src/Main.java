import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double A;
    private double B;
    private double C;
    private double I;
    private double J;
    private double K;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double i = Double.parseDouble(st.nextToken());
        double j = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());

        double t = Math.min(a / i, Math.min(b / j, c / k));

        double remainA = a - i * t;
        double remainB = b - j * t;
        double remainC = c - k * t;

        System.out.printf("%.6f %.6f %.6f\n", remainA, remainB, remainC);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
