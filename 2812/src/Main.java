import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static Deque<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(String.valueOf(input.charAt(i)));
            while (!que.isEmpty() && que.peekLast() < cur && cnt < K) {
                cnt++;
                que.pollLast();
            }
            que.addLast(cur);
        }
        int printCnt = N - K;
        for (int value : que) {
            if (printCnt == 0) break;
            sb.append(value);
            printCnt--;
        }
        System.out.println(sb);
    }
}
