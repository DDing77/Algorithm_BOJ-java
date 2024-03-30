import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int K;
    int[] cards;
    int[] parents;

    private int upperBound(int target) {
        int left = -1;
        int right = cards.length;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (cards[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        parents[y] += parents[x];
        parents[x] = y;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);
        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int originIdx = upperBound(Integer.parseInt(st.nextToken()));
            int unionFindIdx = find(originIdx);
            union(unionFindIdx, unionFindIdx + 1);
            sb.append(cards[unionFindIdx]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
