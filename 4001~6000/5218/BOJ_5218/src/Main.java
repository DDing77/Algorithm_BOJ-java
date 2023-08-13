import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final String preFixMessage = "Distances: ";
    int T;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String message1 = st.nextToken();
            String message2 = st.nextToken();

            sb.append(preFixMessage);
            for (int i = 0; i < message1.length(); i++) {
                int distance = (message1.charAt(i) - 'A') - (message2.charAt(i) - 'A');
                if (distance > 0) {
                    sb.append(26 - distance + " ");
                    continue;
                }
                sb.append(-distance + " ");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
