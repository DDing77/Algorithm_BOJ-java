import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;
    private int[] count;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input = br.readLine();
            input = input.toLowerCase();
            count = new int[26];

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    count[ch - 'a']++;
                }
            }

            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] == 0) {
                    temp.append((char) (i + 'a'));
                }
            }

            if (temp.length() == 0) {
                sb.append("pangram");
            } else {
                sb.append("missing ").append(temp);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
