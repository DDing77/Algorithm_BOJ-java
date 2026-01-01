import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int MAX_SIZE = 1000000;

    private int T;
    private int G;
    private int[] numArr;
    private int[] checkArr;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            G = Integer.parseInt(br.readLine());
            numArr = new int[G];
            for (int i = 0; i < G; i++) {
                numArr[i] = Integer.parseInt(br.readLine());
            }

            checkArr = new int[MAX_SIZE + 1];
            int cur = 1;

            while (true) {
                boolean flag = true;
                for (int i = 0; i < G; i++) {
                    int mod = numArr[i] % cur;
                    if (checkArr[mod] == cur) {
                        flag = false;
                        break;
                    }
                    checkArr[mod] = cur;
                }
                if (flag) {
                    sb.append(cur).append("\n");
                    break;
                }
                cur++;
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
