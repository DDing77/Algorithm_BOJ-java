import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    double max;
    int res;

    private void solution() throws IOException {

        res = -1;
        max = -1;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            double price = Double.parseDouble(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());

            price *= 10;

            if (price >= 5_000) {
                price -= 500;
            }

            weight *= 10;

            if (max < weight / price) {
                res = i;
                max = weight / price;
            }
        }

        if (res == 0) {
            sb.append("S");
        } else if (res == 1) {
            sb.append("N");
        } else {
            sb.append("U");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
