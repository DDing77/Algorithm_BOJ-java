import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int l;
    private int w;
    private int a;

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            if (l == 0 && w == 0 && a == 0) {
                break;
            }

            if (l == 0) {
                sb.append(a / w).append(" ").append(w).append(" ").append(a);
            } else if (w == 0) {
                sb.append(l).append(" ").append(a / l).append(" ").append(a);
            } else {
                sb.append(l).append(" ").append(w).append(" ").append(l * w);
            }
            sb.append('\n');
        }

        System.out.print(sb);


    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
