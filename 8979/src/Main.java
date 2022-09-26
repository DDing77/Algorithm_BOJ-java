import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int idx;
        int gold;
        int silver;
        int copper;

        public Info(int idx, int gold, int silver, int copper) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "idx=" + idx +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", copper=" + copper +
                    '}';
        }
    }

    static Info[] infos;
    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        infos = new Info[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(infos, Comparator.comparingInt(o -> o.idx));

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (infos[i].gold > infos[K - 1].gold) rank++;
            else if (infos[i].gold == infos[K - 1].gold && infos[i].silver > infos[K - 1].silver) rank++;
            else if (infos[i].gold == infos[K - 1].gold && infos[i].silver == infos[K - 1].silver
                    && infos[i].copper > infos[K - 1].copper) rank++;
        }

        System.out.println(rank);
    }
}