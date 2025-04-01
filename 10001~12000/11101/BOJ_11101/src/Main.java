import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private HashMap<String, Integer> cond;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            cond = new HashMap<>();
            String[] condInput = br.readLine().split(",");
            for (String s : condInput) {
                String str = s.split(":")[0];
                int cost = Integer.parseInt(s.split(":")[1]);
                cond.put(str, cost);
            }

            String[] req = br.readLine().split("\\|");
            int res = 1000;
            for (String s : req) {
                String[] comb = s.split("&");
                int max = -1;
                for (String string : comb) {
                    max = Math.max(max, cond.get(string));
                }
                res = Math.min(res, max);
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
