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
    private List<Station> stations;

    private boolean check(int fuel) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];

        que.add(new int[]{0, 0}); // [현재 Station 인덱스, 급유지 방문 횟수]

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[1] > K) {
                continue;
            }

            if (fuel >= stations.get(cur[0]).getLiter(stations.get(N + 1))) {
                return true;
            }

            for (int i = 1; i <= N; i++) {
                if (isVisited[i]) { //탐색했던 곳을 다시 탐색하면 손해
                    continue;
                }

                int nextLiter = stations.get(cur[0]).getLiter(stations.get(i));

                if (nextLiter > fuel) {
                    continue;
                }

                isVisited[i] = true;
                que.add(new int[]{i, cur[1] + 1});
            }
        }
        return false;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stations = new ArrayList<>();
        stations.add(new Station(0, 0));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stations.add(new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        stations.add(new Station(10000, 10000));

        int left = 1;
        int right = stations.get(0).getLiter(stations.get(N + 1)); //1415

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Station {

        int x;
        int y;

        public Station(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getLiter(Station station) {
            double distance = Math.sqrt(Math.pow(station.x - this.x, 2) + Math.pow(station.y - this.y, 2));
            if (distance % 1 != 0) {
                return (int) distance / 10 + 1;
            }
            return (int) distance / 10;
        }
    }

}
