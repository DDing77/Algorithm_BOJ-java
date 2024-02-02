import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    double D;
    double A;
    double B;
    double F;
    double res;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            D = Double.parseDouble(st.nextToken());
            A = Double.parseDouble(st.nextToken());
            B = Double.parseDouble(st.nextToken());
            F = Double.parseDouble(st.nextToken());

            double crashTime = D / (A + B);

            res = F * crashTime;

            sb.append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
