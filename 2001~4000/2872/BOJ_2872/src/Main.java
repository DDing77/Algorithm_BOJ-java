import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] books;
    private int count;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        books = new int[N];

        int maxIdx = -1;
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(br.readLine());
            if (books[i] == N) {
                maxIdx = i;
            }
        }

        count = 1;
        int next = N - 1;
        for (int i = maxIdx; i >= 0; i--) {
            if (books[i] == next) {
                count++;
                next--;
            }
        }

        System.out.println(N - count);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
