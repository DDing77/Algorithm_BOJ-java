import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] magnets;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        magnets = br.readLine().toCharArray();

        for (int i = 0; i < 2 * N - 1; i++) {
            if (magnets[i] == magnets[i + 1]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
