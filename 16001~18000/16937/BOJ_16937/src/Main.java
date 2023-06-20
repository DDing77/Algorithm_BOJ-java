import java.io.IOException;

public class Main {

    static int H;
    static int W;
    static int N;
    static int[][] stickers;
    static int res;

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        H = readInt();
        W = readInt();
        N = readInt();

        stickers = new int[N][2];
        for (int i = 0; i < N; i++) {
            stickers[i][0] = readInt();
            stickers[i][1] = readInt();
        }

        res = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
                        stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
                    res = Math.max(res, stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1]);
                } else if (stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
                        stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
                    res = Math.max(res, stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1]);
                } else if (stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
                        stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
                    res = Math.max(res, stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1]);
                } else if (stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
                        stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
                    res = Math.max(res, stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1]);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}