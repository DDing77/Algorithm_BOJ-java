import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int o;
    private int w;

    private void solution() throws IOException {

        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            o = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (o == 0 && w == 0) {
                break;
            }

            boolean isDeath = false;
            while (true) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (op.equals("#") && value == 0) {
                    break;
                }

                if (op.equals("F")) {
                    w += value;
                } else if (op.equals("E")) {
                    w -= value;
                }

                if (w <= 0) {
                    isDeath = true;
                }
            }

            sb.append(tc++).append(" ");
//            System.out.println("w = " + w);
            if (isDeath) {
                sb.append("RIP").append("\n");
            } else if (o / 2 < w && w < o * 2) {
                sb.append(":-)").append("\n");
            } else {
                sb.append(":-(").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
