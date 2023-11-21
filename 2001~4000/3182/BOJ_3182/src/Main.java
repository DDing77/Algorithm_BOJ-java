import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int[] order;
    boolean[] isVisited;
    int resIdx;

    public int execDFS(int here) {
        int cnt = 1;
        isVisited[here] = true;
        if (!isVisited[order[here]]) {
            cnt += execDFS(order[here]);
        }
        return cnt;
    }

    public void solution() {
        resIdx = 0;
        int cnt;
        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            cnt = execDFS(i);
            if (maxCnt < cnt) {
                maxCnt = cnt;
                resIdx = i;
            }
        }
        System.out.println(resIdx);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
