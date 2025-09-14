import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int[] cows;

    private void swap(int left, int right) {
        while (left <= right) {
            int temp = cows[left];
            cows[left] = cows[right];
            cows[right] = temp;
            left++;
            right--;
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = i + 1;
        }

        st = new StringTokenizer(br.readLine());
        int aLeft = Integer.parseInt(st.nextToken()) - 1;
        int aRight = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int bLeft = Integer.parseInt(st.nextToken()) - 1;
        int bRight = Integer.parseInt(st.nextToken()) - 1;

        int cnt = 1;
        while (true) {
            swap(aLeft, aRight);
            swap(bLeft, bRight);

            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (cows[i] != i + 1) {
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
            cnt++;
        }

        K %= cnt;

        while (K-- > 0) {
            swap(aLeft, aRight);
            swap(bLeft, bRight);
        }

        for (int cow : cows) {
            sb.append(cow).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
