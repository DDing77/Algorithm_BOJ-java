import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    private int T;
    private int[] cnt;
    private int res;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            cnt = new int[26];
            String input = br.readLine().toLowerCase();
            int total = 0;
            for (char c : input.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                cnt[c - 'a']++;
                total++;
            }

            int vowelCnt = 0;
            for (char vowel : vowels) {
                vowelCnt += cnt[vowel - 'a'];
            }

            sb.append(total - vowelCnt).append(" ").append(vowelCnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
