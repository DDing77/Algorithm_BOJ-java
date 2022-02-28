import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static long res = 0;
    static int max = Integer.MIN_VALUE;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            max = Math.max(cur, max);

            if (que.isEmpty()) que.add(cur);
            else {
                if (que.peek() > cur) {
                    que.poll();
                    que.add(cur);
                } else if (que.peek() < cur) {
                    res += cur - que.poll();
                    que.add(cur);
                }
            }
        }

        while (!que.isEmpty()) {
            res += max - que.poll();
        }
        System.out.println(res);
    }
}
