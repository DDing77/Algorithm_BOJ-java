import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] numbers;
    static StringBuilder sb;

    static void backTracking(int depth, int[] res) {
        if (depth == M) {
            for (int i = 0; i < M; i++) sb.append(res[i] + " ");
            sb.append('\n');
            return;
        }

        int pre = -1;
        for (int i = 0; i < N; i++) {
            if (pre != numbers[i]) {
                pre = numbers[i];
                res[depth] = numbers[i];
                backTracking(depth + 1, res);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        sb = new StringBuilder();
        backTracking(0, new int[M]);

        System.out.print(sb);
    }
}
