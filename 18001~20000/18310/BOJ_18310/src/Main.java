import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int[] homes;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        homes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homes);

        if (N % 2 == 1) {
            System.out.println(homes[N / 2]);
        } else {
            System.out.println(homes[N / 2 - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
