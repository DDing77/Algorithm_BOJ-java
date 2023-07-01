import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int min;
    static int max;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        N = Integer.parseInt(br.readLine());
        int cur;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cur = Integer.parseInt(st.nextToken());
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        System.out.println(max - min);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
