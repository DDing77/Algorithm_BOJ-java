import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    HashMap<String, Integer> fail;
    HashSet<String> success;
    int totalPenalty;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fail = new HashMap<>();
        success = new HashSet<>();
        totalPenalty = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            if (time == -1) {
                break;
            }

            String problem = st.nextToken();
            String status = st.nextToken();

            if (success.contains(problem)) {
                continue;
            }

            if (status.equals("right")) {
                success.add(problem);
                totalPenalty += time;

                if (fail.containsKey(problem)) {
                    totalPenalty += fail.get(problem) * 20;
                }
                continue;
            }

            fail.put(problem, fail.getOrDefault(problem, 0) + 1);
        }
        System.out.println(success.size() + " " + totalPenalty);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
