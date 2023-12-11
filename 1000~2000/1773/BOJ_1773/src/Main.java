import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int C;
    boolean[] isVisited;
    int res;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isVisited = new boolean[C + 1];

        res = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            for (int j = cur; j <= C; j += cur) {
                if (!isVisited[j]) {
                    res++;
                    isVisited[j] = true;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

