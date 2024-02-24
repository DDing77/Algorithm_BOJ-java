import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] swapCnt;
    List<Integer> swapIdx;
    int i;
    int j;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        swapCnt = new int[2];
        swapIdx = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= N; k++) {
            int LSB = Integer.parseInt(st.nextToken()) & 1;

            if ((1 & k) != LSB) {
                swapCnt[LSB]++;
                swapIdx.add(k);
            }
        }

        i = -1;
        j = -1;

        if (N != 2 && swapCnt[0] == 0 && swapCnt[1] == 0) {
            i = 1;
            j = 3;
        }
        if (swapCnt[0] == 1 && swapCnt[1] == 1) {
            i = swapIdx.get(0);
            j = swapIdx.get(1);
        }

        sb.append(i).append(" ").append(j);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
