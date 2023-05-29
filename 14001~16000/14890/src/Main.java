import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int[][] map;
    static int res;

    static void solution() {
        for (int i = 0; i < N; i++) {
            canGoPath(i, 0, 0);
            canGoPath(0, i, 1);
        }
    }

    static void canGoPath(int x, int y, int type) {
        int[] height = new int[N];
        boolean[] isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (type == 0) height[i] = map[x][i];
            else height[i] = map[i][y];
        }

        for (int i = 0; i < N - 1; i++) {
            if (height[i] == height[i + 1]) continue;
            else if (height[i] - height[i + 1] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || height[i + 1] != height[j] || isVisited[j]) return;
                    isVisited[j] = true;
                }
            } else if (height[i] - height[i + 1] == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[i] != height[j] || isVisited[j]) return;
                    isVisited[j] = true;
                }
            } else {
                return;
            }
        }

        res++;
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(res);
    }
}