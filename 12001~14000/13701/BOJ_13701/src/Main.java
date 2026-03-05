import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 1 << 25;

    private byte[] visited = new byte[MAX >> 3];

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            int byteIdx = x >> 3;
            int bitIdx = x & 7;

            if ((visited[byteIdx] & (1 << bitIdx)) == 0) {
                visited[byteIdx] |= (1 << bitIdx);
                sb.append(x).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}