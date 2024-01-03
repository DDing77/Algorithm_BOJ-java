import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    int N;
    HashMap<String, Integer> participants;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        participants = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            participants.put(input, participants.getOrDefault(input, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String input = br.readLine();
            participants.put(input, participants.get(input) - 1);
        }

        for (Map.Entry<String, Integer> entry : participants.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
