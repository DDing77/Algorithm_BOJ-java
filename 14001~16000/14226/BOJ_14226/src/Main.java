import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int S;
    boolean[][] isVisited;
    int res;

    private void execBFS() {

        Queue<Display> que = new ArrayDeque<>();
        que.add(new Display(1, 0, 0));
        isVisited = new boolean[S + 1][S + 1];
        isVisited[1][0] = true;

        while (!que.isEmpty()) {
            Display cur = que.poll();

            if (cur.emoticonCount == S) {
                res = cur.operationCount;
                break;
            }

            if (!isVisited[cur.emoticonCount][cur.emoticonCount]) {
                isVisited[cur.emoticonCount][cur.emoticonCount] = true;
                que.add(new Display(cur.emoticonCount, cur.emoticonCount, cur.operationCount + 1));
            }

            if (cur.clipboard != 0 && cur.emoticonCount + cur.clipboard <= S && !isVisited[cur.emoticonCount + cur.clipboard][cur.clipboard]) {
                isVisited[cur.emoticonCount + cur.clipboard][cur.clipboard] = true;
                que.add(new Display(cur.emoticonCount + cur.clipboard, cur.clipboard, cur.operationCount + 1));
            }

            if (cur.emoticonCount - 1 > 1 && !isVisited[cur.emoticonCount - 1][cur.clipboard]) {
                isVisited[cur.emoticonCount - 1][cur.clipboard] = true;
                que.add(new Display(cur.emoticonCount - 1, cur.clipboard, cur.operationCount + 1));
            }
        }
    }

    private void solution() throws IOException {

        S = Integer.parseInt(br.readLine());

        res = Integer.MAX_VALUE;
        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Display {

        int emoticonCount;
        int clipboard;
        int operationCount;

        public Display(int emoticonCount, int clipboard, int operationCount) {
            this.emoticonCount = emoticonCount;
            this.clipboard = clipboard;
            this.operationCount = operationCount;
        }
    }
}
