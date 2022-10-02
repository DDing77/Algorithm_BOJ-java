import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, n;
    static boolean[] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            room = new boolean[n + 1];

            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    room[j] = room[j] == false ? true : false;
                }
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) if (room[i] == false) cnt++;
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
