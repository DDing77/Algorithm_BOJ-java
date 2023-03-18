import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N, B, H, W;
    private int min;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        int cost;
        int numbers;
        for (int i = 0; i < H; i++) {
            cost = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                numbers = Integer.parseInt(st.nextToken());
                if (numbers >= N) {
                    min = Math.min(min, cost * N);
                }
            }
        }

        if (min <= B) {
            System.out.println(min);
        } else {
            System.out.println("stay home");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
