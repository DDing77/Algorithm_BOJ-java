import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Integer> scores;
    private int K;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i += N / K) {
            scores.subList(i, i + N / K).sort(Comparator.naturalOrder());
        }

        for (int i = 0; i < N; i++) {
            sb.append(scores.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
