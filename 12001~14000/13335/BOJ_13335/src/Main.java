import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int W;
    static int L;
    static Queue<Integer> bridge;
    static int[] trucks;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        bridge = new ArrayDeque<>();
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        int sum = 0;
        int time = 0;
        int cnt = 0;
        while (cnt < N) {
            time++;
            sum -= bridge.poll();
            if (sum + trucks[cnt] <= L) {
                sum += trucks[cnt];
                bridge.add(trucks[cnt]);
                cnt++;
            } else {
                bridge.add(0);
            }
        }

        while (!bridge.isEmpty()) {
            time++;
            bridge.poll();
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
