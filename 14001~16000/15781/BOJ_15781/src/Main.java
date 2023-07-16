import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int a = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a = Math.max(a, Integer.parseInt(st.nextToken()));
        }

        int b = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b = Math.max(b, Integer.parseInt(st.nextToken()));
        }

        System.out.println(a + b);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
