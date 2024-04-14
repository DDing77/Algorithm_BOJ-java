import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] prefixSum;

    private void rangeUpdate(int start, int end, int value) {
        update(start, value);
        update(end + 1, -value);
    }

    private void update(int idx, int value) {

        while (idx <= N) {
            prefixSum[idx] += value;
            idx += idx & -idx;
        }
    }

    private int query(int idx) {

        int sum = 0;
        while (idx > 0) {
            sum += prefixSum[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            rangeUpdate(i, i, value);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            rangeUpdate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            sb.append(query(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
