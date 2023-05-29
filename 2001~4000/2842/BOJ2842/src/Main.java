import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int startX, startY;
    static int homeCnt;
    static int res;
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static char[][] map;
    static int[][] number;
    static boolean[][] isVisited;
    static ArrayList<Integer> heightList;

    static int bfs(int left, int right, int cnt) {
        isVisited = new boolean[N][N];
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(startX, startY));
        isVisited[startX][startY] = true;

        while (!que.isEmpty()) {
            Info cur = que.poll();

            for (int k = 0; k < 8; k++) {
                int nX = cur.x + dx[k];
                int nY = cur.y + dy[k];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                if (isVisited[nX][nY]) continue;
                if (left <= number[nX][nY] && number[nX][nY] <= right) {
                    isVisited[nX][nY] = true;
                    if (map[nX][nY] == 'K') {
                        cnt--;
                        if (cnt == 0) return cnt;
                    }
                    que.add(new Info(nX, nY));
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        number = new int[N][N];

        startX = 0;
        startY = 0;
        homeCnt = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'P') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'K') homeCnt++;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        heightList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());
                heightList.add(number[i][j]);
                if (map[i][j] == 'P' || map[i][j] == 'K') {
                    max = Math.max(max, number[i][j]);
                    min = Math.min(min, number[i][j]);
                }
            }
        }

        Collections.sort(heightList);

        res = Integer.MAX_VALUE;
        int start = 0;
        int end = heightList.indexOf(max);
        int maxIdx = heightList.size();
        int minIdx = heightList.indexOf(min);

        while (start <= minIdx && start <= end && end < maxIdx) {
            int left = heightList.get(start);
            int right = heightList.get(end);

            if (bfs(left, right, homeCnt) == 0) {
                res = Math.min(res, right - left);
                start++;
            } else end++;
        }
        System.out.println(res);
    }
}
