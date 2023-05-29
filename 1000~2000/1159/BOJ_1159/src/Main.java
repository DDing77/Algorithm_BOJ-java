import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        alpha = new int[26];

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            alpha[temp[0] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] >= 5) sb.append((char) (i + 'a'));
        }

        if (sb.length() == 0) System.out.println("PREDAJA");
        else System.out.println(sb);
    }
}
