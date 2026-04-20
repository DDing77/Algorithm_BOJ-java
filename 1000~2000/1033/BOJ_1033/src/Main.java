import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long[] nodeArr;
    private ArrayList<Integer>[] edges;
    private boolean[] isVisited;

    private long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private void execDFS(int nodeNum, long value) {
        nodeArr[nodeNum] *= value;

        for (int next : edges[nodeNum]) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                execDFS(next, value);
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        nodeArr = new long[N];
        edges = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        Arrays.fill(nodeArr, 1L);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);

            long left = nodeArr[a] * q;
            long right = nodeArr[b] * p;
            long gcd = getGCD(left, right);

            long mulA = right / gcd;
            long mulB = left / gcd;

            isVisited = new boolean[N];
            isVisited[a] = true;
            isVisited[b] = true;

            execDFS(a, mulA);
            execDFS(b, mulB);
        }

        long totalGCD = nodeArr[0];
        for (int i = 1; i < N; i++) {
            totalGCD = getGCD(totalGCD, nodeArr[i]);
        }

        for (int i = 0; i < N; i++) {
            sb.append(nodeArr[i] / totalGCD).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}