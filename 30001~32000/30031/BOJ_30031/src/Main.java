import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static final Map<String, Integer> moneys = new HashMap<>();
    static StringTokenizer st;
    int N;
    int res;

    private void init() {
        moneys.put("136", 1_000);
        moneys.put("142", 5_000);
        moneys.put("148", 10_000);
        moneys.put("154", 50_000);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            res += moneys.get(st.nextToken());
        }

        sb.append(res);
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
