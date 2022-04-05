import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isVisited;
    static int sharkNode[];
    static ArrayList<Integer>[] edge;

    static class SHARK {
        int size;
        int speed;
        int intelligence;

        public SHARK(int size, int speed, int intelligence) {
            this.size = size;
            this.speed = speed;
            this.intelligence = intelligence;
        }
    }


    static boolean bMatching(int now) {
        for (int next : edge[now]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            if (sharkNode[next] == 0 || bMatching(sharkNode[next])) {
                sharkNode[next] = now;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        sharkNode = new int[N + 1];
        edge = new ArrayList[N + 1];
        SHARK[] shark = new SHARK[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int intelligence = Integer.parseInt(st.nextToken());
            shark[i] = new SHARK(size, speed, intelligence);

            edge[i] = new ArrayList<>();
        }

        int same;
        for (int i = 1; i <= N; i++) {
            same = 0;
            for (int j = 1; j <= N; j++) {
                same = 0;
                if (i == j) continue;
                if (shark[i].size < shark[j].size) continue;
                if (shark[i].size == shark[j].size) same++;

                if (shark[i].speed < shark[j].speed) continue;
                if (shark[i].speed == shark[j].speed) same++;

                if (shark[i].intelligence < shark[j].intelligence) continue;
                if (shark[i].intelligence == shark[j].intelligence) same++;

                if (same == 3) {
                    if (i < j) {
                        edge[i].add(j);
                        continue;
                    }
                } else {
                    edge[i].add(j);
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            if (bMatching(i)) cnt++;
            isVisited = new boolean[N + 1];
            if (bMatching(i)) cnt++;
        }

        System.out.println(N - cnt);
    }
}
