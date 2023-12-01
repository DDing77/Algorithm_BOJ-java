import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] lamp;
    int res;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lamp = new int[M];

        res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                res = Math.max(res, ((lamp[i] - lamp[i - 1]) + 1) / 2);
            }
        }

        if (lamp[0] - res > 0) {
            res += lamp[0] - res;
        }

        if (lamp[M - 1] + res < N) {
            res += N - (lamp[M - 1] + res);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
