import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int X;
    int K;
    boolean[] cups;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cups = new boolean[N + 1];
        cups[X] = true;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            boolean temp = cups[left];
            cups[left] = cups[right];
            cups[right] = temp;
        }

        for (int i = 1; i <= N; i++) {
            if (cups[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
