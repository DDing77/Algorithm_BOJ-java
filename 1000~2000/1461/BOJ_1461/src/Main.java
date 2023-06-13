import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] book;
    static int pivot;
    static int res;

    public static int readInt() throws IOException {

        int c;
        int n = System.in.read() & 15;

        boolean isNegative = n == 13;

        if (isNegative) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return isNegative ? ~n + 1 : n;
    }

    public static void solution() throws IOException {
        N = readInt();
        M = readInt();

        pivot = 0;

        book = new int[N];
        for (int i = 0; i < N; i++) {
            book[i] = readInt();
            if (book[i] < 0) {
                pivot++;
            }
        }

        Arrays.sort(book);

        res = 0;
        for (int i = 0; i < pivot; i += M) {
            res += Math.abs(book[i] * 2);
        }

        for (int i = N - 1; i >= pivot; i -= M) {
            res += Math.abs(book[i] * 2);
        }

        res -= Math.max(Math.abs(book[0]), Math.abs(book[N - 1]));

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
