import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private ArrayList<Integer> resList;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        resList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if ((i % 10 != K % 10) && (i % 10 != 2 * K % 10)) {
                resList.add(i);
            }
        }

        sb.append(resList.size()).append("\n");
        for (int res : resList) {
            sb.append(res).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
