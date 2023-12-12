import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    String[] badges;
    int[] values;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        badges = new String[N];
        values = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            badges[i] = st.nextToken();
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int strong = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N;

            while (left < right) {
                int mid = (left + right) >> 1;
                if (values[mid] < strong) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            sb.append(badges[right]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
