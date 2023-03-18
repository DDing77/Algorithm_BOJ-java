import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private String[] message = {
            "Wa-pa-pa-pa-pa-pa-pow!",
            "Woof-meow-tweet-squeek"
    };
    private int N;
    private int a, b;
    private boolean[][] fingers;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fingers = new boolean[6][6];
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if ((a == 2 && b == 5) || (a == 5 || b == 2)) {
                System.out.println(message[1]);
                return;
            }
            fingers[a][b] = true;
        }

        if ((fingers[1][3] || fingers[3][1]) && (fingers[1][4] || fingers[4][1]) && (fingers[3][4] || fingers[4][3])) {
            System.out.println(message[0]);
        } else {
            System.out.println(message[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
