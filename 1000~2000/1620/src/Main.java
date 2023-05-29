import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<String, Integer> monster;
    static HashMap<Integer, String> idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        monster = new HashMap<>();
        idx = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            monster.put(input, i);
            idx.put(i, input);
        }

        for (int i = 1; i <= M; i++) {
            String input = br.readLine();

            if (monster.containsKey(input)) {
                sb.append(monster.get(input)).append('\n');
            } else {
                sb.append(idx.get(Integer.parseInt(input))).append('\n');
            }
        }
        System.out.println(sb);
    }
}
