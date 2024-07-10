import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String S;
    private int[] alpha;
    private int res;

    private void backTracking(int depth, int preIdx) {

        if (depth == S.length()) {
            res++;
            return;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 0 && (depth == 0 || preIdx != i)) {
                alpha[i]--;
                backTracking(depth + 1, i);
                alpha[i]++;
            }
        }
    }

    private void solution() throws IOException {

        S = br.readLine();
        alpha = new int[26];
        for (int i = 0; i < S.length(); i++) {
            alpha[S.charAt(i) - 'a']++;
        }

        backTracking(0, -1);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
