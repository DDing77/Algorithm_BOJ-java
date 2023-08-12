import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] cardA;
    int cntA;
    int cntB;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cntA = 0;
        cntB = 0;

        cardA = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardA.length; i++) {
            cardA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardA.length; i++) {
            int curB = Integer.parseInt(st.nextToken());
            if (cardA[i] > curB) {
                cntA++;
            } else if (cardA[i] < curB) {
                cntB++;
            }
        }

        if (cntA == cntB) {
            System.out.println("D");
        } else if (cntA > cntB) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
