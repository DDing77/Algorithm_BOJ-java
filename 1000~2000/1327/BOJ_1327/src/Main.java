import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private String curStr;
    private String target;
    private Set<String> set = new HashSet<String>();
    private int res;

    private void setTarget() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            builder.append(i);
        }

        target = builder.toString();
    }

    private String reverseStr(String str, int idx) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < K / 2; i++) {
            char temp = chars[idx + i];
            chars[idx + i] = chars[idx + K - 1 - i];
            chars[idx + K - 1 - i] = temp;
        }

        return new String(chars);
    }

    private void execBFS() {
        Queue<Status> que = new ArrayDeque<Status>();
        que.add(new Status(curStr, 0));
        set.add(curStr);

        while (!que.isEmpty()) {
            Status cur = que.poll();

            if (cur.str.equals(target)) {
                res = cur.cnt;
                return;
            }

            for (int i = 0; i <= N - K; i++) {
                String nextStr = reverseStr(cur.str, i);
                if (!set.contains(nextStr)) {
                    set.add(nextStr);
                    que.add(new Status(nextStr, cur.cnt + 1));
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        setTarget();

        st = new StringTokenizer(br.readLine());
        curStr = "";
        for (int i = 0; i < N; i++) {
            curStr += st.nextToken();
        }

        res = -1;
        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Status {
        String str;
        int cnt;

        public Status(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
