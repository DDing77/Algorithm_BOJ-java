import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int A;
    private int B;
    private int aLength;
    private int bLength;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        aLength = 1;
        bLength = 1;

        for (int i = 0; i < N; i++) {
            aLength += A;
            bLength += B;

            if (bLength > aLength) {
                int temp = bLength;
                bLength = aLength;
                aLength = temp;
            } else if (bLength == aLength) {
                bLength--;
            }
        }

        System.out.println(aLength + " " + bLength);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
