import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int R;
    private int C;
    private int ZR;
    private int ZC;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ZR = Integer.parseInt(st.nextToken());
        ZC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < C; j++) {
                char ch = input.charAt(j);
                for (int k = 0; k < ZC; k++) {
                    tmp.append(ch);
                }
            }
            for (int j = 0; j < ZR; j++) {
                sb.append(tmp).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
