import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private int N;
    private String from;
    private String to;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            from = br.readLine();
            to = br.readLine();

            int needBlack = 0;
            int needWhite = 0;
            for (int i = 0; i < N; i++) {
                if (from.charAt(i) != to.charAt(i)) {
                    if (from.charAt(i) == 'W') {
                        needBlack++;
                    } else {
                        needWhite++;
                    }
                }
            }

            sb.append(Math.max(needBlack, needWhite)).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}