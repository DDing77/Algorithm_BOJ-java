import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<String, String> room = new HashMap<>();
    int N;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        room.put("Algorithm", "204");
        room.put("DataAnalysis", "207");
        room.put("ArtificialIntelligence", "302");
        room.put("CyberSecurity", "B101");
        room.put("Network", "303");
        room.put("Startup", "501");
        room.put("TestStrategy", "105");

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(room.get(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
