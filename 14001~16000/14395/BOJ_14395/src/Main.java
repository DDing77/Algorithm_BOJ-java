import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long s;
    private long t;
    private Set<Long> set;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        if (s == t) {
            System.out.println(0);
            return;
        }

        set = new HashSet<>();
        set.add(s);

        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(s, new StringBuilder()));

        while (!que.isEmpty()) {
            Info cur = que.poll();

            if (cur.value == t) {
                System.out.println(cur.sb.toString());
                return;
            }

            long nextMul = cur.value * cur.value;
            if (!set.contains(nextMul) && nextMul <= t) {
                StringBuilder nextStr = new StringBuilder(cur.sb.toString());
                nextStr.append("*");
                que.add(new Info(nextMul, nextStr));
                set.add(nextMul);
            }

            long nextPlus = cur.value + cur.value;
            if (!set.contains(nextPlus) && nextPlus <= t) {
                StringBuilder nextStr = new StringBuilder(cur.sb.toString());
                nextStr.append("+");
                que.add(new Info(nextPlus, nextStr));
                set.add(nextPlus);
            }

            long nextMinus = 0;
            if (!set.contains(nextMinus)) {
                StringBuilder nextStr = new StringBuilder(cur.sb.toString());
                nextStr.append("-");
                que.add(new Info(nextMinus, nextStr));
                set.add(nextMinus);
            }

            if (cur.value == 0) {
                continue;
            }
            long nextDiv = 1;
            if (!set.contains(nextDiv)) {
                StringBuilder nextStr = new StringBuilder(cur.sb.toString());
                nextStr.append("/");
                que.add(new Info(nextDiv, nextStr));
                set.add(nextDiv);
            }
        }

        System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Info {

        long value;
        StringBuilder sb;

        public Info(long value, StringBuilder sb) {
            this.value = value;
            this.sb = sb;
        }
    }
}
