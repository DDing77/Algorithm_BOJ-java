import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private List<Town> towns = new ArrayList<Town>();

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        long totalCntSum = 0L;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            towns.add(new Town(pos, cnt));
            totalCntSum += cnt;
        }

        Collections.sort(towns, Comparator.comparingInt(o -> o.pos));

        long tempSum = 0L;
        for (int i = 0; i < N; i++) {
            Town town = towns.get(i);
            tempSum += town.cnt;

            if ((totalCntSum + 1) / 2 <= tempSum) {
                System.out.println(town.pos);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Town {
        int pos;
        int cnt;

        public Town(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
