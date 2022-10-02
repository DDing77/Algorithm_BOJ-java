import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int wMax, hMax;
    static int[] dir, dist;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        dir = new int[6];
        dist = new int[6];

        wMax = 0;
        hMax = 0;
        int wIdx = -1;
        int hIdx = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
            if (dir[i] == 1 || dir[i] == 2) {
                if (hMax < dist[i]) {
                    hMax = dist[i];
                    hIdx = i;
                }
            } else {
                if (wMax < dist[i]) {
                    wMax = dist[i];
                    wIdx = i;
                }
            }
        }
        res = wMax * hMax;
        res -= dist[(wIdx + 3) % 6] * dist[(hIdx + 3) % 6];
        System.out.println(res * K);
    }
}
