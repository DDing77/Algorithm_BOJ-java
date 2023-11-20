import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] choose;
    int res;

    public void solution() {
        int cur = 0;
        while (res < N) {
            res++;
            int next = choose[cur];
            if (next == K) {
                break;
            }
            cur = next;
        }

        if (res >= N) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        choose = new int[N];
        for (int i = 0; i < N; i++) {
            choose[i] = Integer.parseInt(br.readLine());
        }
        res = 0;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
