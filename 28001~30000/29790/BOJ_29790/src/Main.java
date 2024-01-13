import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int MIN_SOLVED = 1_000;
    final int MIN_UNION = 8_000;
    final int MAX_LEVEL = 260;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int solved = Integer.parseInt(st.nextToken());
        int union = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());

        if (solved >= MIN_SOLVED) {
            if (union >= MIN_UNION || level >= MAX_LEVEL) {
                System.out.println("Very Good");
            } else {
                System.out.println("Good");
            }
        } else {
            System.out.println("Bad");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
