import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] ans;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        ans = new int[n + 1];
        pq = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int i;
        for (i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            input -= i;
            pq.add(input);
            pq.add(input);
            pq.poll();
            ans[i] = pq.peek();
        }
        --i;

        while (--i > 0) {
            if (ans[i] > ans[i + 1]) ans[i] = ans[i + 1];
        }

        for (i = 1; i <= n; i++) sb.append(ans[i] + i).append('\n');

        System.out.print(sb);

    }
}
