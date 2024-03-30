import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int M;

    private int count(int mid) {

        int cnt = 0;
        while (mid > 0) {
            cnt += mid / 5;
            mid /= 5;
        }

        return cnt;
    }

    private void solution() throws IOException {

        M = Integer.parseInt(br.readLine());

        int left = -1;
        int right = M * 5;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (count(mid) < M) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (count(right) == M) {
            System.out.println(right);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
