import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private int N, type;
    private Set<String> players;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        type = st.nextToken().charAt(0);

        players = new HashSet<>();
        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        if (type == 'Y') {
            System.out.println(players.size());
        } else if (type == 'F') {
            System.out.println(players.size() / 2);
        } else {
            System.out.println(players.size() / 3);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
