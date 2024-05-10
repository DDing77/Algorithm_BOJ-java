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
    private int[] arr;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        int swapCount = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapCount++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                    if (swapCount == K) {
                        System.out.println(arr[i] + " " + arr[i + 1]);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
