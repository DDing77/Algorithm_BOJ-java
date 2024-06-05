import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Egg[] eggs;
    private int res;

    private void backTracking(int via, int count) {

        if (via == N || count == N - 1) {
            res = Math.max(res, count);
            return;
        }
        if (eggs[via].durability <= 0) {
            backTracking(via + 1, count);
        } else {
            for (int i = 0; i < N; i++) {
                if (via == i) {
                    continue;
                }
                if (eggs[i].durability <= 0) {
                    continue;
                }

                int preCountCache = count;

                eggs[via].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[via].weight;

                if (eggs[via].durability <= 0) {
                    preCountCache++;
                }
                if (eggs[i].durability <= 0) {
                    preCountCache++;
                }

                backTracking(via + 1, preCountCache);
                eggs[via].durability += eggs[i].weight;
                eggs[i].durability += eggs[via].weight;
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        backTracking(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Egg {

        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
