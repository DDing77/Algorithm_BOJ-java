import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static String[] word = {
            "baby", "sukhwan", "tururu", "turu",
            "very", "cute", "tururu", "turu",
            "in", "bed", "tururu", "turu",
            "baby", "sukhwan"
    };

    private void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int idx = (N - 1) % 14;
        int k = (N - 1) / 14;

        if (idx <= 1 || idx == 4 || idx == 5 ||
                idx == 8 || idx == 9 || idx == 12 || idx == 13) {
            System.out.println(word[idx]);
        } else {
            int count = k + (idx == 2 || idx == 6 || idx == 10 ? 2 : 1);

            if (count >= 5) {
                sb.append("tu+ru*").append(count);
            } else {
                sb.append(word[idx]);
                for (int i = 0; i < k; i++) {
                    sb.append("ru");
                }
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
