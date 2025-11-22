import java.io.*;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_SIZE = 1_000_000;

    private int N;
    private int[] ballons;
    private int[] remainCntArr;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        ballons = new int[N];
        remainCntArr = new int[MAX_SIZE + 2];

        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ballons[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {

            int cur = ballons[i];
            if (remainCntArr[cur] == 0) {
                res++;
                remainCntArr[cur + 1]++;
            } else {
                remainCntArr[cur]--;
                remainCntArr[cur + 1]++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new  Main();
        main.solution();
    }
}
