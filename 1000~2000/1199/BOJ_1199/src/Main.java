import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] matrix;

    private void getEulerCircuit(int curNode) {
        for (int nextNode = 1; nextNode <= N; nextNode++) {
            while (matrix[curNode][nextNode] > 0) {
                matrix[curNode][nextNode]--;
                matrix[nextNode][curNode]--;
                getEulerCircuit(nextNode);
            }
        }
        sb.append(curNode).append(" ");
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                cnt += matrix[i][j];
            }

            if (cnt % 2 != 0) {
                System.out.println(-1);
                return;
            }
        }

        getEulerCircuit(1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
