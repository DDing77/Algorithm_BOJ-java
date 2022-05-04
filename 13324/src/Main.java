import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long res;
    static int[] arr;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        res = 0;

        pq = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            now -= i;

            pq.add(now);
            arr[i] = pq.peek();

        }
        System.out.println(res);
    }
}
