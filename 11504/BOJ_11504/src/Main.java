import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T;
    private int N, M;
    private String a, b;
    private int[] numbers;
    private int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            a = "";
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                a += st.nextToken();
            }

            b = "";
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                b += st.nextToken();
            }

            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            for (int i = 0; i < N; i++) {
                String temp = "";

                for (int j = 0; j < M; j++) {
                    temp += String.valueOf(numbers[(i + j) % N]);
                }
                if (temp.compareTo(a) >= 0 && temp.compareTo(b) <= 0) {
                    res++;
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
