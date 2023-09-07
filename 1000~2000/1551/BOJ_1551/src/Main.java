import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] A;
    int[] B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ",");
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        while (K-- > 0) {
            for (int i = 0; i < N - 1; i++) {
                A[i] = A[i + 1] - A[i];
            }
            N--;
        }

        int cnt = N - 1;
        for (int i = 0; i < N; i++) {
            sb.append(A[i]);
            if (cnt > 0) {
                sb.append(",");
            }
            cnt--;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
