import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] first;
    static int[] second;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        first = new int[2];
        second = new int[2];
        boolean isFirst = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if (!isFirst) {
                        first[0] = i;
                        first[1] = j;
                        isFirst = true;
                    } else {
                        second[0] = i;
                        second[1] = j;
                    }
                }
            }
        }

        res = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
