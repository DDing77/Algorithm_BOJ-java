import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private int C;
    private List<Integer>[] edges;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        edges = new List[11];
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                if (A * i + B * j == C) {
                    edges[i].add(j);
                }
            }

            if (edges[i].isEmpty()) {
                sb.append(0);
            } else {
                for (Integer node : edges[i]) {
                    sb.append(node).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
