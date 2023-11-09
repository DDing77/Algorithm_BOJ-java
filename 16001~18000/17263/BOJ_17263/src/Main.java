import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int max;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Integer.parseInt(st.nextToken()));
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
