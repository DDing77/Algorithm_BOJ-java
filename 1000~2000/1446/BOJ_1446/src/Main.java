import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final int MAX_LENGTH = 10000;
    int N;
    int D;
    int[] distance;
    ArrayList<ShortCut>[] path;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        path = new ArrayList[MAX_LENGTH + 1];
        for (int i = 0; i < MAX_LENGTH + 1; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end - start > dist) {
                path[end].add(new ShortCut(start, dist));
            }
        }

        distance = new int[D + 1];
        Arrays.fill(distance, MAX_LENGTH + 1);

        distance[0] = 0;
        for (int i = 1; i <= D; i++) {
            if (path[i].size() > 0) {
                for (ShortCut cur : path[i]) {
                    if (distance[i] < distance[cur.start] + cur.dist) {
                        continue;
                    }
                    distance[i] = Math.min(distance[i - 1] + 1, distance[cur.start] + cur.dist);
                }
            } else {
                distance[i] = distance[i - 1] + 1;
            }
        }

        System.out.println(distance[D]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class ShortCut {
        int start;
        int dist;

        public ShortCut(int start, int dist) {
            this.start = start;
            this.dist = dist;
        }
    }
}
