import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] select;
    static int[][] forbidden;
    static boolean[] isVisited;
    static int res;

    static void backTracking(int idx, int cnt) {
        if (cnt == 3) {
            if (forbidden[select[0]][select[1]] != 1 && forbidden[select[1]][select[2]] != 1 && forbidden[select[0]][select[2]] != 1)
                res++;
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                select[cnt] = i;
                backTracking(i + 1, cnt + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[3];
        forbidden = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            forbidden[a][b] = 1;
            forbidden[b][a] = 1;
        }

        res = 0;
        backTracking(1, 0);

        System.out.println(res);
    }
}
