import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] galaxy;
    private int[] planet;
    private int res;

    public int find(int x) {
        if (galaxy[x] < 0) {
            return x;
        }

        return galaxy[x] = find(galaxy[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (galaxy[a] < galaxy[b]) {
            galaxy[a] += galaxy[b];
            galaxy[b] = a;
            planet[a] += planet[b];
        } else {
            galaxy[b] += galaxy[a];
            galaxy[a] = b;
            planet[b] += planet[a];
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        galaxy = new int[N + 1];
        planet = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            galaxy[i] = -1;
            planet[i] = Integer.parseInt(br.readLine());
        }

        res = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
            sb.append(planet[find(from)]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
