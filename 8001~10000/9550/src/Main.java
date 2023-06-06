import java.io.IOException;

public class Main {

    static int T;
    static int N;
    static int K;
    static int res;


    public static int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        T = readInt();
        while (T-- > 0) {
            N = readInt();
            K = readInt();

            res = 0;
            for (int i = 0; i < N; i++) {
                res += readInt() / K;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}