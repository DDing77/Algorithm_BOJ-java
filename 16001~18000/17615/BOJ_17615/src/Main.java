import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String balls;
    int res;

    public void cal(char type, int total) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == type) {
                cnt++;
            } else {
                break;
            }
        }
        res = Math.min(res, total - cnt);

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == type) {
                cnt++;
            } else {
                break;
            }
        }
        res = Math.min(res, total - cnt);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = br.readLine();

        res = Integer.MAX_VALUE;

        int redTotal = 0;
        int blueTotal = 0;

        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') {
                redTotal++;
            } else {
                blueTotal++;
            }
        }

        cal('R', redTotal);
        cal('B', blueTotal);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
