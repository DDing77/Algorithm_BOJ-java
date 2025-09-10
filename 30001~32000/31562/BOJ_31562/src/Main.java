import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private HashMap<String, List<String>> map;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            char[] chars = new char[7];
            for (int j = 0; j < 7; j++) {
                chars[j] = st.nextToken().charAt(0);
            }

            String key = String.valueOf(chars[0]) + chars[1] + chars[2];
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(S);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char[] chars = new char[3];
            for (int j = 0; j < 3; j++) {
                chars[j] = st.nextToken().charAt(0);
            }

            String key = String.valueOf(chars[0]) + chars[1] + chars[2];
            if (!map.containsKey(key)) {
                sb.append("!");
            } else {
                List<String> list = map.get(key);
                if (list.size() > 1) {
                    sb.append("?");
                } else {
                    sb.append(list.get(0));
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
