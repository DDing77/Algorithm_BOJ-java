import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String input;
    static int K;
    static int[] S;
    static boolean[] isVisited;
    static StringBuilder sb;

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (isVisited[i]) sb.append(S[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            isVisited[i] = true;
            dfs(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;
            S = new int[K];
            for (int i = 0; i < K; i++) S[i] = Integer.parseInt(st.nextToken());

            isVisited = new boolean[K];
            dfs(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

