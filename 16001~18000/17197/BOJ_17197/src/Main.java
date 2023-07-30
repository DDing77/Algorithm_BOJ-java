import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    Cow[] cows;
    int res;

    public int find(int x) {
        if (cows[x].parent < 0) {
            return x;
        }
        return cows[x].parent = find(cows[x].parent);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        cows[y].parent = x;
        cows[x].maxX = Math.max(cows[x].maxX, cows[y].maxX);
        cows[x].maxY = Math.max(cows[x].maxY, cows[y].maxY);
        cows[x].minX = Math.min(cows[x].minX, cows[y].minX);
        cows[x].minY = Math.min(cows[x].minY, cows[y].minY);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(-1, x, x, y, y);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (cows[i].parent < 0) {
                int width = cows[i].maxX - cows[i].minX;
                int height = cows[i].maxY - cows[i].minY;
                res = Math.min(res, 2 * (width + height));
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Cow {
        int parent;
        int maxX;
        int minX;
        int maxY;
        int minY;

        public Cow(int parent, int maxX, int minX, int maxY, int minY) {
            this.parent = parent;
            this.maxX = maxX;
            this.minX = minX;
            this.maxY = maxY;
            this.minY = minY;
        }
    }
}
