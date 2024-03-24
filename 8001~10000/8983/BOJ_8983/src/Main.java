import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int M;
    int N;
    int L;
    int[] hunters;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        hunters = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            hunters[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunters);

        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y > L) {
                continue;
            }

            int minX = x - (L - y);
            int maxX = x + (L - y);

            int left = 0;
            int right = M - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (minX <= hunters[mid] && hunters[mid] <= maxX) {
                    res++;
                    break;
                }

                if (hunters[mid] < minX) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
