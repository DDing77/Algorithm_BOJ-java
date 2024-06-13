import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private LinkedHashMap<String, List<String>> map;

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            map = new LinkedHashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(br.readLine(), new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String voter = st.nextToken();
                String candidate = st.nextToken();
                if (map.containsKey(candidate)) {
                    map.get(candidate).add(voter);
                } else {
                    map.put(candidate, new ArrayList<>());
                    map.get(candidate).add(voter);
                }
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                for (String voters : entry.getValue()) {
                    sb.append(voters).append("\n");
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
