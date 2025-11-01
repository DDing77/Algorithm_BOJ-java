import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int rh;
    private int rv;
    private int sh;
    private int sv;
    private int N;
    private int res;

    private int getPrice(int rhi, int rvi, int shi, int svi, int pi) {
        int horiz = (int) Math.max(Math.ceil((double) rh / rhi), Math.ceil((double) sh / shi));
        int vertical = (int) Math.max(Math.ceil((double) rv / rvi), Math.ceil((double) sv / svi));
        return horiz * vertical * pi;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        rh = Integer.parseInt(st.nextToken());
        rv = Integer.parseInt(st.nextToken());
        sh = Integer.parseInt(st.nextToken());
        sv = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int rhi = Integer.parseInt(st.nextToken());
            int rvi = Integer.parseInt(st.nextToken());
            int shi = Integer.parseInt(st.nextToken());
            int svi = Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());

            int horiz = getPrice(rhi, rvi, shi, svi, pi);
            int vertical = getPrice(rvi, rhi, svi, shi, pi);
            res = Math.min(res, Math.min(horiz, vertical));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
