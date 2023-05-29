import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, S;
    private int[] lengths;
    private long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        lengths = new int[N];
        for (int i = 0; i < N; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }

        res = 0;
        Arrays.sort(lengths);
        int right = N - 1;
        for (int i = 0; i < N; i++) {
            if (S / 2 < lengths[i]) break;
            while (lengths[i] + lengths[right] > S) {
                right--;
            }
            res += right - i;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
