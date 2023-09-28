import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    final int[] dir = {10, 60, 600};
    String[] input;
    boolean[][] isVisited;
    int time;
    int res;

    public void execBFS() {
        Queue<Recipe> que = new ArrayDeque<>();
        que.add(new Recipe(false, 0, 0));

        while (!que.isEmpty()) {
            Recipe cur = que.poll();

            if (cur.isStart && cur.totalTime == time) {
                res = cur.cnt;
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                if (cur.totalTime + dir[i] > time) {
                    break;
                }
                if(cur.isStart) {
                    if(!isVisited[1][cur.totalTime + dir[i]]) {
                        isVisited[1][cur.totalTime + dir[i]] = true;
                        que.add(new Recipe(true, cur.totalTime + dir[i], cur.cnt + 1));
                    }
                } else {
                    if(!isVisited[0][cur.totalTime + dir[i]]) {
                        isVisited[0][cur.totalTime + dir[i]] = true;
                        que.add(new Recipe(false, cur.totalTime + dir[i], cur.cnt + 1));
                    }
                }
            }

            if (!cur.isStart) {
                if (cur.totalTime == 0) {
                    que.add(new Recipe(true, 30, cur.cnt + 1));
                } else {
                    que.add(new Recipe(true, cur.totalTime, cur.cnt + 1));
                }
            } else {
                que.add(new Recipe(true, cur.totalTime + 30, cur.cnt + 1));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(":");

        time = Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
        isVisited = new boolean[2][time + 1];

        res = 0;
        execBFS();

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Recipe {
        boolean isStart;
        int totalTime;
        int cnt;

        public Recipe(boolean isStart, int totalTime, int cnt) {
            this.isStart = isStart;
            this.totalTime = totalTime;
            this.cnt = cnt;
        }
    }
}
