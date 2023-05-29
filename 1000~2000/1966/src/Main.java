import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, M;

    static class Info {
        int idx;
        int weight;

        public Info(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static Queue<Info> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            pq = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int idx = i;
                int input = Integer.parseInt(st.nextToken());
                pq.add(new Info(idx, input));
            }
            int cnt = 0;
            while (!pq.isEmpty()) {
                Info cur = pq.poll();
                boolean flag = true;

                for (Info next : pq) {
                    if (next.weight > cur.weight) {
                        flag = false;
                    }
                }
                if (flag) {
                    cnt++;
                    if (cur.idx == M) {
                        sb.append(cnt).append('\n');
                        break;
                    }
                } else pq.add(cur);
            }
        }
        System.out.print(sb);
    }
}

