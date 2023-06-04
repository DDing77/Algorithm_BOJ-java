import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int n;
    static int player1Cnt;
    static int player2Cnt;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            player1Cnt = 0;
            player2Cnt = 0;

            n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());

                char player1 = st.nextToken().charAt(0);
                char player2 = st.nextToken().charAt(0);

                if (player1 == 'R') {
                    if (player2 == 'P') {
                        player2Cnt++;
                    }
                    if (player2 == 'S') {
                        player1Cnt++;
                    }
                }

                if (player1 == 'P') {
                    if (player2 == 'R') {
                        player1Cnt++;
                    }
                    if (player2 == 'S') {
                        player2Cnt++;
                    }
                }

                if (player1 == 'S') {
                    if (player2 == 'R') {
                        player2Cnt++;
                    }
                    if (player2 == 'P') {
                        player1Cnt++;
                    }
                }
            }

            if (player1Cnt == player2Cnt) {
                sb.append("TIE");
            } else if (player1Cnt > player2Cnt) {
                sb.append("Player 1");
            } else {
                sb.append("Player 2");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}