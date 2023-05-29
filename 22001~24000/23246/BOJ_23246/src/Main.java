import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private class Player implements Comparable<Player> {
        int id;
        int mul;
        int sum;

        public Player(int id, int mul, int sum) {
            this.id = id;
            this.mul = mul;
            this.sum = sum;
        }

        @Override
        public int compareTo(Player o) {
            if (this.mul == o.mul) {
                if (this.sum == o.sum) {
                    return this.id - o.id;
                }
                return this.sum - o.sum;
            }
            return this.mul - o.mul;
        }
    }

    private Player[] players;
    private int N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        players = new Player[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            players[i] = new Player(b, (p * q * r), (p + q + r));
        }

        Arrays.sort(players);

        for (int i = 0; i < 3; i++) {
            sb.append(players[i].id + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
