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

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while (1 <= loc && newItem < arr[loc]) {
                cnt++;
                arr[loc + 1] = arr[loc];
                if (cnt == K) {
                    System.out.println(arr[loc + 1]);
                    return;
                }
                loc--;
            }

            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                cnt++;
                if (cnt == K) {
                    System.out.println(arr[loc + 1]);
                    return;
                }
            }
        }

        System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
