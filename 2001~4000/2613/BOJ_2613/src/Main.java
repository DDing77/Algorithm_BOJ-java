import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] beads;
    int[] res;

    private boolean check(int mid) {

        int groutCount = 1;
        int count = 0;
        int sum = 0;
        int[] tempCntArray = new int[M];

        for (int i = 0; i < N; i++) {
            if(groutCount > M) {
                return false;
            }

            if(sum + beads[i] > mid || N - i <= M - groutCount) {
                tempCntArray[groutCount -1] = count;
                groutCount++;
                count = 1;
                sum = beads[i];
            } else {
                count++;
                sum += beads[i];
            }
        }

        if(groutCount > M) {
            return false;
        }

        tempCntArray[groutCount - 1] = count;
        for (int i = 0; i < M; i++) {
            res[i] = tempCntArray[i];
        }
        return true;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beads = new int[N];
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, beads[i]);
            right += beads[i];
        }

        left--;
        res = new int[M];
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        sb.append(right).append("\n");
        for (int count : res) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
