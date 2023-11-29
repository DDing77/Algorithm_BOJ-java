import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    String A;
    String B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        int diff;
        if (A.length() > B.length()) {
            diff = A.length() - B.length();
            sb.append(A, 0, diff);
            for (int i = 0; i < B.length(); i++) {
                sb.append((A.charAt(i + diff) - '0') + (B.charAt(i) - '0'));
            }
        } else if (A.length() < B.length()) {
            diff = B.length() - A.length();
            sb.append(B, 0, diff);
            for (int i = 0; i < A.length(); i++) {
                sb.append((A.charAt(i) - '0') + (B.charAt(i + diff) - '0'));
            }
        } else {
            for (int i = 0; i < A.length(); i++) {
                sb.append((A.charAt(i) - '0') + (B.charAt(i) - '0'));
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
