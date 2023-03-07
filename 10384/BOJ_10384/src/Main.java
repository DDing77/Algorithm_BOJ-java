import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public final String[] message = {
            "Case",
            "Not a pangram",
            "Pangram!",
            "Double pangram!!",
            "Triple pangram!!!"
    };
    private int N;
    private int[] alpha;
    private int min;
    private boolean isSame;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            alpha = new int[26];

            String input = br.readLine().toLowerCase();
            for (int j = 0; j < input.length(); j++) {
                char cur = input.charAt(j);

                if ('a' <= cur && cur <= 'z') {
                    alpha[cur - 'a']++;
                }
            }

            min = alpha[0];
            isSame = true;
            for (int j = 1; j < 26; j++) {
                min = Math.min(min, alpha[j]);
                if (alpha[j - 1] != alpha[j]) {
                    isSame = false;
                }
            }

            if (min == 0) {
                sb.append(message[0] + " " + i + ": " + message[1]);
            } else if (min <= 2) {
                sb.append(message[0] + " " + i + ": " + message[min + 1]);
            } else {
                sb.append(message[0] + " " + i + ": " + message[4]);
            }
            sb.append('\n');
        }


        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
