import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] boxes;
    private int[] books;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boxes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        books = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        int bookIdx = 0;
        for (int i = 0; i < N; i++) {
            while (bookIdx < M && boxes[i] - books[bookIdx] >= 0) {
                boxes[i] -= books[bookIdx];
                bookIdx++;
            }
        }

        for (int i = 0; i < N; i++) {
            res += boxes[i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
