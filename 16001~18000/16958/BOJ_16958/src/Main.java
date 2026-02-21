import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int T;
    private int M;
    private City[] cities;
    private int[] minSpecialDist;
    private ArrayList<Integer> specialList = new ArrayList<>();

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        cities = new City[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cities[i] = new City(S, x, y);

            if (S == 1) {
                specialList.add(i);
            }
        }

        minSpecialDist = new int[N];

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;

            for (int idx : specialList) {
                int dist = Math.abs(cities[i].x - cities[idx].x)
                        + Math.abs(cities[i].y - cities[idx].y);
                min = Math.min(min, dist);
            }

            minSpecialDist[i] = min;
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            int direct = Math.abs(cities[A].x - cities[B].x)
                    + Math.abs(cities[A].y - cities[B].y);

            int teleport = minSpecialDist[A] + T + minSpecialDist[B];

            sb.append(Math.min(direct, teleport)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class City {
        int S;
        int x;
        int y;

        public City(int s, int x, int y) {
            S = s;
            this.x = x;
            this.y = y;
        }
    }
}