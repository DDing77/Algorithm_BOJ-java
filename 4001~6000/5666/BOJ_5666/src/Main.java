import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int H;
    int P;
    double res;

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            H = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            res = (double) H / P;

            sb.append(String.format("%.2f", res)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
