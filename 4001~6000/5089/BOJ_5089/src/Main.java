import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Set<String> set;

    private void solution() throws IOException {
        int weekNum = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            set = new HashSet<>();
            int delCnt = 0;
            for (int i = 0; i < N; i++) {
                String city = br.readLine();
                set.add(city);
            }

            sb.append("Week").append(" ").append(weekNum++).append(" ").append(set.size()).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
