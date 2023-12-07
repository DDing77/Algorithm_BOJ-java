import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    String word;
    char[] count;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            word = br.readLine();
            count = new char[26];

            int baseLine = -1;
            for (int i = word.length() - 1; i > 0; i--) {
                count[word.charAt(i) - 'A']++;
                if (word.charAt(i - 1) < word.charAt(i)) {
                    count[word.charAt(i - 1) - 'A']++;
                    baseLine = i - 1;
                    break;
                }
            }

            if (baseLine == -1) {
                res.append(word).append("\n");
                continue;
            }

            for (int i = 0; i < baseLine; i++) {
                res.append(word.charAt(i));
            }

            int baseCharASCII = word.charAt(baseLine) - 'A';
            for (int i = baseCharASCII + 1; i < count.length; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    res.append((char) (i + 'A'));
                    break;
                }
            }

            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    res.append((char) (i + 'A'));
                }
            }

            res.append("\n");
        }
        System.out.print(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
