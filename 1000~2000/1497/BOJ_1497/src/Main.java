import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private String[] nameArr;
    private long[] infoArr;
    private int resMin;
    private long resMax;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nameArr = new String[N];
        infoArr = new long[N];

        boolean noOne = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nameArr[i] = st.nextToken();
            String info = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (info.charAt(j) == 'Y') {
                    infoArr[i] |= 1L << j;
                    noOne = false;
                }
            }
        }

        if (noOne) {
            System.out.println("-1");
            return;
        }

        int size = 1 << N;
        resMax = -1;
        for (int bit = 1; bit < size; bit++) {
            long temp = 0L;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    cnt++;
                    temp |= infoArr[i];
                }
            }

            int songCnt = Long.bitCount(temp);
            if (songCnt > resMax) {
                resMin = cnt;
                resMax = songCnt;
            } else if (songCnt == resMax && cnt < resMin) {
                resMin = cnt;
            }
        }

        System.out.println(resMin);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
