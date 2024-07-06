import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private long sum;
    private int xor;

    private void solution() throws IOException {

        M = Integer.parseInt(br.readLine());
        sum = 0L;
        xor = 0;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int number = Integer.parseInt(st.nextToken());
                sum += number;
                xor ^= number;
            } else if (op == 2) {
                int target = Integer.parseInt(st.nextToken());
                sum -= target;
                xor ^= target;
            } else if (op == 3) {
                sb.append(sum).append("\n");
            } else if (op == 4) {
                sb.append(xor).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
