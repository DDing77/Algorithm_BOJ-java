import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static int[] res;
    static boolean[] visit;
    static HashSet<String> set = new HashSet<>();
    static void dfs(int depth, int start) {
        if (depth == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(res[i]).append(" ");
            }
            if(!set.contains(temp.toString())) {
                sb.append(temp.toString()).append("\n");
                set.add(temp.toString());
            };
            return;
        }

        for (int i = start; i < N; i++) {

            res[depth] = arr[i];
            dfs(depth + 1 ,i);

        }

    }

    static void solution() {
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N];
        res = new int[M];
        solution();
    }
}
