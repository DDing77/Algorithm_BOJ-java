import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] cardsA;
    int[] scores;
    int lastWin;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        cardsA = new int[10];
        scores = new int[2];
        lastWin = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            cardsA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            int cardB = Integer.parseInt(st.nextToken());
            if (cardsA[i] > cardB) {
                lastWin = 1;
                scores[0] += 3;
            } else if (cardsA[i] == cardB) {
                scores[0]++;
                scores[1]++;
            } else {
                scores[1] += 3;
                lastWin = 2;
            }
        }

        sb.append(scores[0] + " " + scores[1]).append('\n');
        if (lastWin == 0) {
            sb.append("D");
        } else if (scores[0] > scores[1]) {
            sb.append("A");
        } else if (scores[0] < scores[1]) {
            sb.append("B");
        } else {
            if (lastWin == 1) {
                sb.append("A");
            } else if (lastWin == 2) {
                sb.append("B");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
