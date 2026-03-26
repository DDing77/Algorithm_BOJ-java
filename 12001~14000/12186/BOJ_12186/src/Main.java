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

    private int T;
    private int N;
    private HashMap<String, String> ticketMap = new HashMap<>();
    private HashSet<String> destinationSet = new HashSet<>();

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ticketMap.clear();
            destinationSet.clear();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String from = br.readLine();
                String to = br.readLine();

                ticketMap.put(from, to);
                destinationSet.add(to);
            }

            String start = null;
            for (String from : ticketMap.keySet()) {
                if (!destinationSet.contains(from)) {
                    start = from;
                    break;
                }
            }

            sb.append("Case #").append(tc).append(": ");

            String current = start;
            for (int i = 0; i < N; i++) {
                String next = ticketMap.get(current);
                sb.append(current).append("-").append(next);

                if (i != N - 1) {
                    sb.append(" ");
                }

                current = next;
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
