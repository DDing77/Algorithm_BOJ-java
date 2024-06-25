import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private HashMap<Integer, Queue<Integer>> sushiOrderList;
    private int[] ateCount;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sushiOrderList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                int sushiNumber = Integer.parseInt(st.nextToken());

                if (!sushiOrderList.containsKey(sushiNumber)) {
                    sushiOrderList.put(sushiNumber, new ArrayDeque<>());
                }
                sushiOrderList.get(sushiNumber).add(i);
            }
        }

        ateCount = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int sushiNumber = Integer.parseInt(st.nextToken());
            if (sushiOrderList.containsKey(sushiNumber)) {
                int cNum = sushiOrderList.get(sushiNumber).poll();
                if (sushiOrderList.get(sushiNumber).size() == 0) {
                    sushiOrderList.remove(sushiNumber);
                }
                ateCount[cNum]++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(ateCount[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
