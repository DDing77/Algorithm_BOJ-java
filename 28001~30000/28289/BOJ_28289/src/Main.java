import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] counts;

    private void solution() throws IOException {

        counts = new int[4];
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (G == 1) {
                counts[3]++;
            } else if (C <= 2) {
                counts[0]++;
            } else if (C == 3) {
                counts[1]++;
            } else if (C == 4) {
                counts[2]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            sb.append(counts[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
