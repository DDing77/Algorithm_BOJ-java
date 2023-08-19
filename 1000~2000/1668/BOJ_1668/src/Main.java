import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int[] trophy;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        trophy = new int[N];
        for (int i = 0; i < N; i++) {
            trophy[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int maxLeft = trophy[0];
        int right = 1;
        int maxRight = trophy[N - 1];
        for (int i = 1; i < N; i++) {
            if (trophy[i] > maxLeft) {
                maxLeft = trophy[i];
                left++;
            }
            if (trophy[N - 1 - i] > maxRight) {
                maxRight = trophy[N - 1 - i];
                right++;
            }
        }

        sb.append(left).append('\n').append(right);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
