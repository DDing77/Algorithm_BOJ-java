import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_LENGTH = 9000;

    private int N;
    private int M;
    private boolean[] primeArr = new boolean[MAX_LENGTH + 1];
    private int[] cows;
    private boolean[] selected;
    private TreeSet<Integer> resList = new TreeSet<>();

    private void execDFS(int idx, int sum, int depth) {
        if (depth == M) {
            if (!primeArr[sum]) {
                resList.add(sum);
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                execDFS(i + 1, sum + cows[i], depth + 1);
                selected[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= Math.sqrt(MAX_LENGTH); i++) {
            if (!primeArr[i]) {
                for (int j = i + i; j <= MAX_LENGTH; j += i) {
                    primeArr[j] = true;
                }
            }
        }

        cows = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        selected = new boolean[N];
        execDFS(0, 0, 0);

        if (resList.isEmpty()) {
            System.out.println("-1");
            return;
        }
        for (Integer prime : resList) {
            sb.append(prime).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
