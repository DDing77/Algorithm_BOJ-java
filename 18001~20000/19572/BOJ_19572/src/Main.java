import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    double x;
    double y;
    double z;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        z = Double.parseDouble(st.nextToken());

        double a = (x + y - z) / 2;
        double b = x - a;
        double c = y - a;

        if (a <= 0 || b <= 0 || c <= 0) {
            sb.append(-1);
        } else {
            sb.append(1).append("\n").append(a).append(" ").append(b).append(" ").append(c);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
