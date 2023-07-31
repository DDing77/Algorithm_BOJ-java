import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final int SIZE = 5;
    int T;
    int[] scores;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            scores = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores);

            if (scores[3] - scores[1] >= 4) {
                sb.append("KIN").append('\n');
                continue;
            }

            int sum = 0;
            for (int i = 1; i < 4; i++) {
                sum += scores[i];
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
