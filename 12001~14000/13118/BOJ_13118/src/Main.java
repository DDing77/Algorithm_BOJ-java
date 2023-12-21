import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] p;
    int x;
    int y;
    int r;
    int res;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        p = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p.length; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == x) {
                res = i + 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
