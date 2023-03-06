import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T;
    private String A, B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            int cnt = A.length();
            for (int i = 0; i <= A.length() - B.length(); i++) {

                if (A.charAt(i) != B.charAt(0)) {
                    continue;
                }

                if (A.substring(i, i + B.length()).equals(B)) {
                    cnt -= B.length() - 1;
                    i += B.length() - 1;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        new Main().solution();
    }
}
