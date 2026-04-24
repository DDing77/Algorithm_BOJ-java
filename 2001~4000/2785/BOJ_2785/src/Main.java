import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] chains;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        chains = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chains[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chains);

        int tiedChainCnt = 1;
        int remainChainCnt = N;
        for (int chain : chains) {
            if (chain + tiedChainCnt >= remainChainCnt) {
                break;
            }
            remainChainCnt--;
            tiedChainCnt += chain;
        }

        System.out.println(remainChainCnt - 1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
