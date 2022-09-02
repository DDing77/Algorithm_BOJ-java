import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        alpha = new int[m][26];

        int distance = 0;

        String[] dnas = new String[n];

        for (int i = 0; i < n; i++) {
            dnas[i] = br.readLine();

            for (int j = 0; j < m; j++) {
                alpha[j][dnas[i].charAt(j) - 'A'] += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int max = alpha[i][0];
            char target = 'A';
            for (int j = 0; j < 26; j++) {
                if (alpha[i][j] > max) {
                    max = alpha[i][j];
                    target = (char) (j + 'A');
                }
            }
            sb.append(target);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dnas[i].charAt(j) != sb.charAt(j)) distance++;
            }
        }

        System.out.println(sb);
        System.out.println(distance);
    }
}