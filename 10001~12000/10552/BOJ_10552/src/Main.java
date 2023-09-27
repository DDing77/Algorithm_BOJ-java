import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int M;
    int P;
    ArrayList<Info>[] channels;
    boolean[] isVisited;
    int res;

    public void execBFS() {
        isVisited = new boolean[M + 1];
        isVisited[P] = true;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(P);
        res = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Info next : channels[cur]) {
                if (isVisited[next.favoriteChannel]) {
                    res = -1;
                    return;
                }

                res++;
                que.add(next.favoriteChannel);
                isVisited[next.favoriteChannel] = true;
                break;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        channels = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            channels[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            channels[from].add(new Info(i, to));
        }

//        for (int i = 1; i <= M; i++) {
//            Collections.sort(channels[i]);
//        }

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Info implements Comparable<Info> {
        int order;
        int favoriteChannel;

        public Info(int order, int favoriteChannel) {
            this.order = order;
            this.favoriteChannel = favoriteChannel;
        }

        @Override
        public int compareTo(Info o) {
            return this.order - o.order;
        }
    }
}
