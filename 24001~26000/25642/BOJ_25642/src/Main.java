import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean isYT = false;
        boolean isYJ = false;

        while (!isYT && !isYJ) {
            B += A;
            if (B >= 5) {
                isYT = true;
            }
            A += B;
            if (A >= 5) {
                isYJ = true;
            }
        }

        if (isYT) {
            System.out.println("yt");
        } else {
            System.out.println("yj");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
