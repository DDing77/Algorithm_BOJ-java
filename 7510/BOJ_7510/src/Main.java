import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final String sub = "Scenario #";
    static int T;
    static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            len = new int[3];
            len[0] = Integer.parseInt(st.nextToken());
            len[1] = Integer.parseInt(st.nextToken());
            len[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(len);

            sb.append(sub).append(tc + ":").append('\n');
            if (len[0] * len[0] + len[1] * len[1] == len[2] * len[2]) {
                sb.append("yes").append('\n');
            } else sb.append("no").append('\n');

            sb.append('\n');
        }
        System.out.print(sb);
    }
}

