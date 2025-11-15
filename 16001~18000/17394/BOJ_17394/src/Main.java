import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int A;
    private int B;
    private boolean[] primeArr;

    private void initPrimeArray() {
        primeArr = new boolean[1_000_001];
        primeArr[0] = true;
        primeArr[1] = true;
        for (int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            if (!primeArr[i]) {
                for (int j = i + i; j < primeArr.length; j += i) {
                    primeArr[j] = true;
                }
            }
        }
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        initPrimeArray();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            boolean[] isVisited = new boolean[1_000_001];
            isVisited[N] = true;
            Queue<int[]> que = new ArrayDeque<>();
            que.add(new int[]{N, 0});

            int resCnt = -1;
            while (!que.isEmpty()) {
                int[] cur = que.poll();

                if (!primeArr[cur[0]] && A <= cur[0] && cur[0] <= B) {
                    resCnt = cur[1];
                    break;
                }

                int next = cur[0] / 2;
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }

                next = cur[0] / 3;
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }

                next = cur[0] + 1;
                if (next <= 1_000_000 && !isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }

                next = cur[0] - 1;
                if (next > 0 && !isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }
            }

            sb.append(resCnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
