import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int L;
    int N;
    int[] cake;
    int[][] cnt;
    int expectedMax;
    int expectedIdx;
    int actualMax;
    int actualIdx;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        cake = new int[L + 1];
        cnt = new int[N + 1][2];

        expectedMax = 0;
        expectedIdx = 0;
        actualMax = 0;
        actualIdx = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            cnt[i][0] = end - start + 1;
            if (expectedMax < cnt[i][0]) {
                expectedMax = cnt[i][0];
                expectedIdx = i;
            }

            for (int j = start; j <= end; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    cnt[i][1]++;
                }
            }

            if (actualMax < cnt[i][1]) {
                actualMax = cnt[i][1];
                actualIdx = i;
            }
        }

        sb.append(expectedIdx).append('\n').append(actualIdx);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
