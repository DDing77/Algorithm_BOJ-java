import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> dq;
    static int[] arr;
    static int N, M;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) dq.add(i);

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        for (int i = 0; i < M; i++) {
            int midIdx;
            int targetIdx = dq.indexOf(arr[i]);

            if (dq.size() % 2 == 0) midIdx = dq.size() / 2 - 1;
            else midIdx = dq.size() / 2;

            if (targetIdx <= midIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int temp = dq.pollFirst();
                    dq.addLast(temp);
                    cnt++;
                }
            } else {
                for (int j = 0; j < dq.size() - targetIdx; j++) {
                    int temp = dq.pollLast();
                    dq.addFirst(temp);
                    cnt++;
                }
            }
            dq.pollFirst();
        }
        System.out.println(cnt);
    }
}