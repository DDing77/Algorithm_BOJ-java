import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int h;

    private void solution() throws IOException {
        h = Integer.parseInt(br.readLine());
        if (h == 0) {
            sb.append("1");
        } else if (h == 1) {
            sb.append("0");
        } else {
            if (h % 2 == 1) {
                sb.append("4");
            }
            for (int i = 0; i < h / 2; i++) {
                sb.append("8");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
