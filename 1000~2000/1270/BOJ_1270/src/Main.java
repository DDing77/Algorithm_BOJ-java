import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    int N;
    int T;
    HashMap<String, Integer> soldier;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            soldier = new HashMap<>();
            boolean isFind = false;

            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            for (int j = 0; j < T; j++) {
                String cur = st.nextToken();
                soldier.put(cur, soldier.getOrDefault(cur, 0) + 1);
                if (soldier.get(cur) > T / 2) {
                    sb.append(cur).append("\n");
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                sb.append("SYJKGW").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
