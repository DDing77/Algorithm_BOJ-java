import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Player> firstRound = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int rank = Integer.parseInt(br.readLine());
            Player player = new Player(i + 1);
            firstRound.add(rank - 1, player);
        }

        List<Player> nextCandi = new ArrayList<>();
        for (int i = M - 1; i >= 0; i--) {
            nextCandi.add(firstRound.get(i));
        }

        List<Player> secondRound = new ArrayList<>();
        for (Player player : nextCandi) {
            int rank = Integer.parseInt(br.readLine());
            secondRound.add(rank - 1, player);
        }

        for (int i = 0; i < 3; i++) {
            sb.append(secondRound.get(i).playerNumber).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Player {

        int playerNumber;

        public Player(int playerNumber) {
            this.playerNumber = playerNumber;
        }
    }
}
