import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[][] alpha;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            alpha = new int[26][26];

            st = new StringTokenizer(br.readLine());

            String cur = st.nextToken();
            for (int i = 0; i < cur.length(); i++) {
                alpha[0][cur.charAt(i) - 'a']++;
            }

            cur = st.nextToken();
            for (int i = 0; i < cur.length(); i++) {
                alpha[1][cur.charAt(i) - 'a']++;
            }

            boolean flag = true;
            for (int i = 0; i < alpha[0].length; i++) {
                if (alpha[0][i] != alpha[1][i]) {
                    sb.append("Impossible");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("Possible");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
