import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int R;
    int C;
    int N;
    int M;
    int[] papers;

    private boolean check(int mid) {

        int count = 1;
        int pre = papers[0];
        for (int i = 1; i < papers.length; i++) {
            if (pre + mid <= papers[i]) {
                count++;
                pre = papers[i];
            }

            if (count > N) {
                return false;
            }
        }

        return true;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = Math.min(R, C);

        papers = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            papers[i] = b;
            left = Math.max(left, r - 1);
        }

        Arrays.sort(papers);

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
