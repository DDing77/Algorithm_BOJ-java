import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int[] num;
    static boolean[] isVisited;
    static int res;

    public static void execDFS(int idx) {
        if (isVisited[idx]) {
            return;
        }

        isVisited[idx] = true;
        execDFS(num[idx]);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            isVisited = new boolean[N + 1];
            num = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    res++;
                    execDFS(i);
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
