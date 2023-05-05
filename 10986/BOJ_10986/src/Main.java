import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int M;
    private int[] mods;
    private int sum;
    private long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mods = new int[M];
        sum = 0;
        res = 0;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            sum %= M;

            if (sum == 0) {
                res++;
            }

            res += mods[sum];
            mods[sum]++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
