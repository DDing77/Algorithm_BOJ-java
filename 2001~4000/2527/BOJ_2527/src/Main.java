import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int TEST_CASE = 4;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < TEST_CASE; i++) {

            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r3 = Integer.parseInt(st.nextToken());
            int c3 = Integer.parseInt(st.nextToken());
            int r4 = Integer.parseInt(st.nextToken());
            int c4 = Integer.parseInt(st.nextToken());

            if (r3 > r2 || r4 < r1 || c1 > c4 || c2 < c3) {
                sb.append("d");
            } else if ((r1 == r4 && c1 == c4) || (r2 == r3 && c1 == c4) || (r2 == r3 && c2 == c3) || (r1 == r4 && c2 == c3)) {
                sb.append("c");
            } else if (r2 == r3 || c2 == c3 || c1 == c4 || r1 == r4) {
                sb.append("b");
            } else {
                sb.append("a");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
