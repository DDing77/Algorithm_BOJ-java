import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T;
    private int N, C;
    private int[] candy, temps;
    private int res;

    public void makeEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
            }
        }
    }

    public boolean chkAllSame(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            candy = new int[N];
            temps = new int[N];

            st = new StringTokenizer(br.readLine());
            candy = new int[N];
            for (int i = 0; i < N; i++) {
                candy[i] = Integer.parseInt(st.nextToken());
            }
            makeEven(candy);

            res = 0;
            while (!chkAllSame(candy)) {
                res++;
                for (int i = 0; i < N; i++) {
                    temps[i] = candy[i] / 2;
                    candy[i] /= 2;
                }

                for (int i = 0; i < N; i++) {
                    candy[(i + 1) % N] += temps[i];
                }
                makeEven(candy);
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}