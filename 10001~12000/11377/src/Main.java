import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;
    static int[] task;
    static int res = 0;

    static boolean DFS(int start) {
        for (int next : list[start]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            if (task[next] == 0 || DFS(task[next])) {
                task[next] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        task = new int[M + 1];

        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            for (int j = 0; j < input; j++) list[i].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= 2 * N; i++) {
            isVisited = new boolean[M + 1];
            if (i <= N) {
                if (DFS(i)) res++;
            } else {
                if (K > 0 && DFS(i - N)) {
                    res++;
                    K--;
                }
            }
        }
        System.out.println(res);
    }
}