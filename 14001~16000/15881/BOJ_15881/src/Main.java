import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] word;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        word = br.readLine().toCharArray();

        int idx = 0;
        while (idx < N - 3) {
            if (word[idx] == 'p'
                    && word[idx + 1] == 'P'
                    && word[idx + 2] == 'A'
                    && word[idx + 3] == 'p') {
                res++;
                idx += 4;
            } else {
                idx++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
