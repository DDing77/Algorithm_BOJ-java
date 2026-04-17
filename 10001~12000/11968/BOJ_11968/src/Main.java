import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private boolean[] checkArr;
    private Queue<Integer> bQueue;
    private Queue<Integer> eQueue;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = N * 2;

        checkArr = new boolean[M + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            checkArr[num] = true;
        }

        bQueue = new ArrayDeque<>();
        eQueue = new ArrayDeque<>();
        for (int i = 1; i <= M; i++) {
            if (!checkArr[i]) {
                bQueue.add(i);
            } else {
                eQueue.add(i);
            }
        }

        while (!bQueue.isEmpty()) {
            if (bQueue.peek() > eQueue.peek()) {
                res++;
                bQueue.poll();
                eQueue.poll();
            } else {
                bQueue.poll();
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
