import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Country {
        int x;
        int y;

        public Country(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static ArrayList<Country> list;
    static int sum;
    static int res;

    static boolean canMerge(int a, int b) {
        if (L <= Math.abs(a - b) && Math.abs(a - b) <= R) return true;
        return false;
    }

    static void bfs(int x, int y) {
        Queue<Country> que = new LinkedList<>();
        que.add(new Country(x, y));
        sum = map[x][y];

        while (!que.isEmpty()) {
            Country cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            for (int k = 0; k < 4; k++) {
                int newX = curX + dX[k];
                int newY = curY + dY[k];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                if (isVisited[newX][newY]) continue;

                if (canMerge(map[curX][curY], map[newX][newY])) {
                    isVisited[newX][newY] = true;
                    que.add(new Country(newX, newY));
                    list.add(new Country(newX, newY));
                    sum += map[newX][newY];
                }
            }
        }
    }

    static void change() {
        for (Country country : list) {
            map[country.x][country.y] = sum / list.size();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        while (true) {
            isVisited = new boolean[N][N];
            boolean canGo = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        list = new ArrayList<>();
                        list.add(new Country(i, j));
                        isVisited[i][j] = true;
                        sum = 0;
                        bfs(i, j);
                        if (list.size() > 1) {
                            canGo = true;
                            change();
                        }
                    }
                }
            }
            if (!canGo) break;
            res++;
        }
        System.out.println(res);
    }
}