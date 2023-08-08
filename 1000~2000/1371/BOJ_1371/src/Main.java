import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int[] alpha;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        alpha = new int[26];

        String input;
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    alpha[input.charAt(i) - 'a']++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, alpha[i]);
        }


        for (int i = 0; i < 26; i++) {
            if (max == alpha[i]) {
                sb.append((char) (i + 'a'));
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
