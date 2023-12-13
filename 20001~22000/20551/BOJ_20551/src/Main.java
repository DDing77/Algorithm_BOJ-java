import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] numbers;

    private int lowerBound(int D) {
        int left = 0;
        int right = N - 1;
        int mid;

        while (left < right) {
            mid = (left + right) >> 1;

            if (numbers[mid] >= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            int idx = lowerBound(D);
            if (numbers[idx] == D) {
                sb.append(idx);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
