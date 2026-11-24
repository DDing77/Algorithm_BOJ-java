import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] word;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        word = br.readLine().toCharArray();

        for (int i = 0; i < N / 2; i++) {
            if (word[i] == '?' && word[N - 1 - i] == '?') {
                word[i] = 'a';
                word[N - 1 - i] = word[i];
            } else if (word[i] == '?' && word[N - 1 - i] != '?') {
                word[i] = word[N - 1 - i];
            } else if (word[i] != '?' && word[N - 1 - i] == '?') {
                word[N - 1 - i] = word[i];
            }
        }

        if (word[N / 2] == '?') {
            word[N / 2] = 'a';
        }

        for (char c : word) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
