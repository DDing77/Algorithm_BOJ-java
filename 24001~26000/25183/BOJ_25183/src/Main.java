import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] S;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        S = new int[N];

        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            S[i] = input.charAt(i) - 'A';
        }

        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (Math.abs(S[i - 1] - S[i]) == 1) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (cnt == 5) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
