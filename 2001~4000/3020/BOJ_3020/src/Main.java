import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, H;
    static int[] bottom;
    static int[] up;
    static int[] bottomSum;
    static int[] upSum;
    static int min;
    static int same;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[H + 1];
        up = new int[H + 1];
        bottomSum = new int[H + 1];
        upSum = new int[H + 1];

        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= H; i++) {
            bottomSum[i] = bottomSum[i - 1] + bottom[i];
            upSum[i] = upSum[i - 1] + up[i];
        }

        min = N;
        same = 0;
        for (int i = 1; i <= H; i++) {
            int cnt = 0;

            cnt = cnt + bottomSum[H] - bottomSum[i - 1];
            cnt = cnt + upSum[H] - upSum[H - i];

            if (cnt > min) continue;
            else if (cnt == min) same++;
            else {
                min = cnt;
                same = 1;
            }
        }

        System.out.println(min + " " + same);
    }
}
