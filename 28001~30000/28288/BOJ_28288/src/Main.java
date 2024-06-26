import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private char[][] scheduleBoard;
    private int max;
    private int[] ySumArr;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        scheduleBoard = new char[N][5];

        for (int i = 0; i < N; i++) {
            scheduleBoard[i] = br.readLine().toCharArray();
        }

        ySumArr = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N; j++) {
                if (scheduleBoard[j][i] == 'Y') {
                    ySumArr[i]++;
                }
            }
            max = Math.max(max, ySumArr[i]);
        }

        for (int i = 0; i < 5; i++) {
            if (max == ySumArr[i]) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(i + 1);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
