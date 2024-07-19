import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int G;
    private HashSet<Integer> set;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            G = Integer.parseInt(br.readLine());
            set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < G; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (set.contains(number)) {
                    set.remove(number);
                } else {
                    set.add(number);
                }
            }

            for (int number : set) {
                sb.append("Case #").append(tc).append(": ").append(number).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
