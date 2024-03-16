import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    char alpha;
    int res;

    private void solution() throws IOException {

        String input;
        while (!(input = br.readLine()).equals("#")) {
            st = new StringTokenizer(input);
            alpha = st.nextToken().charAt(0);
            res = 0;

            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
                for (char c : word.toCharArray()) {
                    if (c == alpha) {
                        res++;
                    }
                }
            }

            sb.append(alpha).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
