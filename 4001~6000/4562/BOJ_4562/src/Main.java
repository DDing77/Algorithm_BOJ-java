import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String[] messages = {"NO BRAINS", "MMM BRAINS"};
    static int n;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) >= Integer.parseInt(st.nextToken())) {
                sb.append(messages[1]).append('\n');
            } else {
                sb.append(messages[0]).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
