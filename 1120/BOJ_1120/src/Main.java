import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String A, B;
    static int res;

    static int getCnt(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        res = B.length();
        if (A.compareTo(B) == 0) res = 0;
        else if (A.length() == B.length()) {
            res = getCnt(A, B);
        } else {
            int size = A.length();
            for (int i = 0; i <= B.length() - size; i++) {
                String sub = B.substring(i, i + size);
                res = Math.min(res, getCnt(A, sub));
            }
        }
        System.out.println(res);
    }
}
