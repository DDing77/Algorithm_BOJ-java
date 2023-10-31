import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cur = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(j == M) {
                    sb.append(cur++).append('\n');
                } else {
                    sb.append(cur++).append(" ");
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
