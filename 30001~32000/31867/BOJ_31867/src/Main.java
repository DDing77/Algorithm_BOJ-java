import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String K;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = br.readLine();

        int evenCnt = 0;
        int oddCnt = 0;

        for (int i = 0; i < N; i++) {
            int number = K.charAt(i) - '0';
            if (number % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        if (evenCnt > oddCnt) {
            System.out.println(0);
        } else if (evenCnt < oddCnt) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
