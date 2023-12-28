import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String cur = st.nextToken();

            for (int i = 0; i < cur.length(); i++) {
                char curChar = cur.charAt(i);
                sb.append(cur.charAt(i));
                if (curChar == 'a' || curChar == 'e' || curChar == 'i' || curChar == 'o' || curChar == 'u') {
                    i += 2;
                    continue;
                }
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
