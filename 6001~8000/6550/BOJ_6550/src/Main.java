import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String a, b, input;

    public static boolean getResult() {
        int idx = 0;

        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(idx) == b.charAt(i)) {
                idx++;
            }

            if (idx == a.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            a = st.nextToken();
            b = st.nextToken();

            if (!getResult()) {
                sb.append("No");
            } else {
                sb.append("Yes");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
