import java.io.IOException;

public class Main {

    int T;
    int N;
    int[] numbers;
    long res;

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        T = readInt();
        while (T-- > 0) {
            N = readInt();
            numbers = new int[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = readInt();
            }

            res = 0L;
            int peek = numbers[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (numbers[i] > peek) {
                    peek = numbers[i];
                } else if (numbers[i] < peek) {
                    res += peek - numbers[i];
                }
            }

            sb.append(res).append('\n');
        }

        System.out.println(sb);
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
