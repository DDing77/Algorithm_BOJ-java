import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    class Condo implements Comparable<Condo> {
        int D;
        int C;

        public Condo(int d, int c) {
            D = d;
            C = c;
        }

        @Override
        public int compareTo(Condo o) {
            if (this.D == o.D) {
                return this.C - o.C;
            }
            return this.D - o.D;
        }
    }

    private int N;
    private Condo[] condos;
    private int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        condos = new Condo[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            condos[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(condos);

        res = 0;
        int maxCost = Integer.MAX_VALUE;
        for (Condo cur : condos) {
            if (cur.C < maxCost) {
                res++;
                maxCost = cur.C;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}