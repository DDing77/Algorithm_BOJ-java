import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final String[] message = {"Yonsei", " Korea", "Draw"};
    private int T;
    private int yonseiScore;
    private int koreaScore;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            yonseiScore = 0;
            koreaScore = 0;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                yonseiScore += Integer.parseInt(st.nextToken());
                koreaScore += Integer.parseInt(st.nextToken());
            }

            if (yonseiScore == koreaScore) {
                sb.append(message[2]);
            } else if (yonseiScore > koreaScore) {
                sb.append(message[0]);
            } else {
                sb.append(message[1]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
