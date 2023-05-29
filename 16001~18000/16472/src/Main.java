import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] count;
    static int N, ans = 0, kind = 0;
    static String str;

    static void getAns() {
        for (int L = 0, R = 0; R < str.length(); R++) {
            // 일단 추가
            count[str.charAt(R) - 'a']++;
            if (count[str.charAt(R) - 'a'] == 1) kind++;

            while (kind > N) {
                count[str.charAt(L) - 'a']--;
                if (count[str.charAt(L) - 'a'] == 0) kind--;
                L++;
            }
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        count = new int[26];

        getAns();
    }
}
