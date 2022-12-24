import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] pointX;
    static int[] pointY;
    static int[] distance;
    static long total;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pointX = new int[N];
        pointY = new int[N];
        distance = new int[N];

        total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointX[i] = Integer.parseInt(st.nextToken());
            pointY[i] = Integer.parseInt(st.nextToken());

            if (i == 0) continue;

            distance[i] = Math.abs(pointX[i] - pointX[i - 1]) + Math.abs(pointY[i] - pointY[i - 1]);
            total += distance[i];
        }

        res = total;
        for (int i = 1; i < N - 1; i++) {
            long temp = total;
            temp -= distance[i];
            temp -= distance[i + 1];

            temp += Math.abs(pointX[i + 1] - pointX[i - 1]) + Math.abs(pointY[i + 1] - pointY[i - 1]);
            res = Math.min(res, temp);
        }

        System.out.println(res);

    }
}

