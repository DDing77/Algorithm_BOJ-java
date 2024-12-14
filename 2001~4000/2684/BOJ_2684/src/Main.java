import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int P;
    private char[] coins;
    private int[] typeCounts;

    private void solution() throws IOException {

        P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            coins = br.readLine().toCharArray();
            typeCounts = new int[8];

            for (int i = 0; i < coins.length - 2; i++) {
                if (coins[i] == 'H') {
                    if (coins[i + 1] == 'H' && coins[i + 2] == 'H') {
                        typeCounts[7]++;
                    } else if (coins[i + 1] == 'H' && coins[i + 2] == 'T') {
                        typeCounts[6]++;
                    } else if (coins[i + 1] == 'T' && coins[i + 2] == 'H') {
                        typeCounts[5]++;
                    } else if (coins[i + 1] == 'T' && coins[i + 2] == 'T') {
                        typeCounts[4]++;
                    }
                } else {
                    if (coins[i + 1] == 'H' && coins[i + 2] == 'H') {
                        typeCounts[3]++;
                    } else if (coins[i + 1] == 'H' && coins[i + 2] == 'T') {
                        typeCounts[2]++;
                    } else if (coins[i + 1] == 'T' && coins[i + 2] == 'H') {
                        typeCounts[1]++;
                    } else if (coins[i + 1] == 'T' && coins[i + 2] == 'T') {
                        typeCounts[0]++;
                    }
                }
            }

            for (int typeCount : typeCounts) {
                sb.append(typeCount).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
