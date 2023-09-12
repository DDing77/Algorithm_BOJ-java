import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    ArrayList<Integer> lionIdx;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lionIdx = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == 1) {
                lionIdx.add(i);
            }
        }

        if (lionIdx.size() < K) {
            System.out.println(-1);
            return;
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < lionIdx.size(); i++) {
            int end = i;
            int cnt = 0;

            while (end < lionIdx.size() && cnt < K) {
                cnt++;
                end++;
            }

            if (cnt == K) {
                res = Math.min(res, lionIdx.get(end - 1) - lionIdx.get(i) + 1);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
