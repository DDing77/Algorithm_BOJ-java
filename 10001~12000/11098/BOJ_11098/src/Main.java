import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int p;
    static Player[] players;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            p = Integer.parseInt(br.readLine());
            players = new Player[p];

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                players[i] = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            }

            Arrays.sort(players);

            sb.append(players[p - 1].name).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Player implements Comparable<Player> {
        int price;
        String name;

        public Player(int price, String name) {
            this.price = price;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return price - o.price;
        }
    }
}
