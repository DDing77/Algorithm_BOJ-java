import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int n;
    private String[] card1;
    private String[] card2;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            card1 = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                card1[i] = st.nextToken();
            }
            Arrays.sort(card1);

            card2 = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                card2[i] = st.nextToken();
            }
            Arrays.sort(card2);

            boolean isDirty = false;
            for (int i = 0; i < n; i++) {
                if (!card1[i].equals(card2[i])) {
                    isDirty = true;
                    break;
                }
            }

            if (!isDirty) {
                sb.append("NOT CHEATER");
            } else {
                sb.append("CHEATER");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
