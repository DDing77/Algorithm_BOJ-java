import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] cards;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        int maxValue = -1;
        int maxIdx = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            if (maxValue < cards[i]) {
                maxValue = cards[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (maxIdx == i) {
                continue;
            }
            res += maxValue + cards[i];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
