import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int R;
    int C;
    int[] distance;
    int mainDistance;
    int res;

    public int getDistance(int a, int b) {
        if (a == 1) {
            return b;
        } else if (a == 2) {
            return C + R + (C - b);
        } else if (a == 3) {
            return C + R + C + (R - b);
        } else {
            return C + b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        distance = new int[N];
        int mainY = 0;
        int mainX = 0;

        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (i == N) {
                mainDistance = getDistance(a, b);
                break;
            }

            distance[i] = getDistance(a, b);
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            int path = Math.abs(mainDistance - distance[i]);
            res += Math.min(path, R + R + C + C - path);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
