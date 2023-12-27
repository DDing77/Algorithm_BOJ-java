import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int scoreD;
    int scoreP;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        scoreD = 0;
        scoreP = 0;

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String input = br.readLine();
            if (input.equals("D")) {
                scoreD++;
            } else {
                scoreP++;
            }

            if (Math.abs(scoreD - scoreP) == 2) {
                break;
            }
        }

        System.out.println(scoreD + ":" + scoreP);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
