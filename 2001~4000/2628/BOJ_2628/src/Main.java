import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int cnt;
    static int[] mList, nList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        mList = new int[M + 1];
        nList = new int[N + 1];

        cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (op == 0) nList[num] = 1;
            else mList[num] = 1;
        }

        int length = 0;
        int maxN = 0;
        int maxM = 0;

        for (int i = 1; i <= N; i++) {
            length++;
            if (nList[i] == 1 || i == N) {
                maxN = Math.max(maxN, length);
                length = 0;
            }
        }

        length = 0;
        for (int i = 1; i <= M; i++) {
            length++;
            if (mList[i] == 1 || i == M) {
                maxM = Math.max(maxM, length);
                length = 0;
            }
        }

        System.out.println(maxM * maxN);
    }
}
