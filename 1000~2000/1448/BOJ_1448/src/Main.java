import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] lines;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        lines = new int[N];
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        for (int i = N - 1; i > 1; i--) {
            if (lines[i] < lines[i - 1] + lines[i - 2]) {
                System.out.println(lines[i] + lines[i - 1] + lines[i - 2]);
                return;
            }
        }

        System.out.println("-1");
        return;
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
