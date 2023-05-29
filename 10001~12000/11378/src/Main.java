import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static boolean[] isVisited;
    static int[] task;
    static ArrayList<Integer>[] edges;
    static int res;

    static boolean binaryMatch(int cur) {
        for (int next : edges[cur]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;

            if (task[next] == 0 || binaryMatch(task[next])) {
                task[next] = cur;
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

        isVisited = new boolean[M + 1];
        task = new int[M + 1];
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            for (int j = 0; j < input; j++) edges[i].add(Integer.parseInt(st.nextToken()));
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[M + 1];
            if (binaryMatch(i)) res++;
        }

        for (int i = 1; i <= N; i++) {
            while (K > 0) {
                isVisited = new boolean[M + 1];
                if (!binaryMatch(i)) break;
                K--;
                res++;
            }
        }

        System.out.println(res);
    }
}