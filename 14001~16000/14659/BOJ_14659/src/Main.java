import java.io.IOException;

public class Main {

    int N;
    int res;

    public void solution() throws IOException {
        N = readInt();
        res = 0;
        int cnt = 0;

        int curMax = readInt();

        for (int i = 0; i < N - 1; i++) {
            int cur = readInt();

            if (curMax > cur) {
                cnt++;
                res = Math.max(res, cnt);
            } else if (curMax < cur) {
                curMax = cur;
                cnt = 0;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
