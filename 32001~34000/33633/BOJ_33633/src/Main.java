import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private ArrayList<Long> ans = new ArrayList<>();

    private void solve(int depth, long A) {
        if (depth == 1) {
            ans.add(A);
            return;
        }

        if (A != 4 && A % 2 == 0 && A % 3 == 1) {
            solve(depth - 1, (A - 1) / 3);
        }

        solve(depth - 1, A * 2);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        solve(N, 1);

        Collections.sort(ans);

        sb.append(ans.size()).append("\n");
        for (long v : ans) {
            sb.append(v).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
