import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private final HashMap<Integer, Player> rankingBoard = new HashMap<>();

    private void solution() throws IOException {
        while (true) {
            rankingBoard.clear();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int idx = Integer.parseInt(st.nextToken());
                    if (rankingBoard.containsKey(idx)) {
                        rankingBoard.get(idx).up();
                    } else {
                        rankingBoard.put(idx, new Player(idx, 0));
                    }
                }
            }

            ArrayList<Player> players = new ArrayList<>(rankingBoard.values());
            Collections.sort(players);

            int bia = players.get(1).cnt;
            for (int i = 1; i < players.size(); i++) {
                if (players.get(i).cnt < bia) {
                    break;
                }
                sb.append(players.get(i).idx + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Player implements Comparable<Player> {
        int idx;
        int cnt;

        public Player(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        public void up() {
            cnt++;
        }

        @Override
        public int compareTo(Player o) {
            if (this.cnt == o.cnt) {
                return this.idx - o.idx;
            }
            return o.cnt - this.cnt;
        }
    }
}
