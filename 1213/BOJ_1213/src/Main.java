import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String name;
    static int[] alpha;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        name = br.readLine();
        alpha = new int[26];

        for (int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }

        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) oddCnt++;
        }

        res = "";
        if (oddCnt > 1) res += "I'm Sorry Hansoo";
        else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) sb.append((char) (i + 65));
            }
            res += sb.toString();
            String temp = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alpha[i] % 2 == 1) sb.append((char) (i + 65));
            }

            res += sb.toString();
            res += temp;
        }
        System.out.println(res);
    }
}
