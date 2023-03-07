import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private boolean[] menus;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        menus = new boolean[N];

        res = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2* N; i++) {
            int cur = Integer.parseInt(st.nextToken()) - 1;
            if (!menus[cur]) {
                cnt++;
                menus[cur] = true;
                res = Math.max(res, cnt);
            } else {
                cnt--;
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
