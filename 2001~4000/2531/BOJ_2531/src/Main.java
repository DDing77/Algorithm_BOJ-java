import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;
    static int[] sushi;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        cnt = 0;
        int left = 0;
        int right = 0;
        while (right < k) {
            if (dq.isEmpty() || !dq.contains(sushi[right])) cnt++;
            dq.addLast(sushi[right++]);
        }

        int res = 1;
        while (left < N) {
            int pre = dq.pollFirst();
            int newInput = sushi[right++];

            if (!dq.contains(pre)) cnt--;
            if (!dq.contains(newInput)) cnt++;
            dq.addLast(newInput);

            res = Math.max(res, !dq.contains(c) ? cnt + 1 : cnt);

            right %= N;
            left++;
        }

        System.out.println(res);
    }
}
