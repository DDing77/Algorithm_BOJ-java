import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int a;
    private PriorityQueue<Integer> present;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        present = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (present.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(present.poll()).append("\n");
                }
            } else {
                for (int j = 0; j < a; j++) {
                    present.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
