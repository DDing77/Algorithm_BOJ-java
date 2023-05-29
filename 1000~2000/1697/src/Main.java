import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] map;

    static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == K) break;
            if (now < map.length-1 && map[now + 1] == 0) {
                que.add(now + 1);
                map[now + 1] = map[now] + 1;
            }
            if (now * 2 < map.length && map[now * 2] == 0) {
                que.add(now * 2);
                map[now * 2] = map[now] + 1;
            }
            if (now - 1 >= 0 && map[now - 1] == 0) {
                que.add(now - 1);
                map[now - 1] = map[now] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        if(N == K ) {
            System.out.println(0);
            return;
        }
        BFS(N);
//        System.out.println(Arrays.toString(map));
        System.out.println(map[K]);
    }
}
