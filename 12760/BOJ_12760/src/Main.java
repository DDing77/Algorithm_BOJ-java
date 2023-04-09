import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, M;
    private int[][] cards;
    private int[] ranks;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cards[i]);
        }

        int maxRank = 0;
        ranks = new int[N];
        for (int j = 0; j < M; j++) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (cards[i][j] > max) {
                    max = cards[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                if (max == cards[i][j]) {
                    ranks[i]++;
                    maxRank = Math.max(maxRank, ranks[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (maxRank == ranks[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
