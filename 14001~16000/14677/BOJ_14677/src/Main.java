import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int N;
    private int[] medicines;
    private boolean[][] isVisited;
    private int res;

    private void execBFS() {
        int left = 0;
        int right = medicines.length - 1;
        isVisited[left][right] = true;

        Queue<int[]> que = new ArrayDeque<>();
        if (medicines[left] == 0 && left + 1 <= right) {
            que.add(new int[]{left + 1, right, 0});
            isVisited[left + 1][right] = true;
        }
        if (medicines[right] == 0 && right - 1 >= left) {
            que.add(new int[]{left, right - 1, 0});
            isVisited[left][right - 1] = true;
        }

        res = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int l = cur[0];
                int r = cur[1];
                int pre = cur[2];

                if (l > r) continue;

                int want = (pre + 1) % 3;

                if (l <= r && medicines[l] == want && !isVisited[l + 1][r]) {
                    que.add(new int[]{l + 1, r, want});
                    isVisited[l + 1][r] = true;
                }

                if (l <= r && medicines[r] == want && !isVisited[l][r - 1]) {
                    que.add(new int[]{l, r - 1, want});
                    isVisited[l][r - 1] = true;
                }
            }
            res++;
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        medicines = new int[N * 3];

        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                medicines[i] = 1;
            } else if (chars[i] == 'D') {
                medicines[i] = 2;
            }
        }

        isVisited = new boolean[N * 3 + 5][N * 3 + 5];

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
